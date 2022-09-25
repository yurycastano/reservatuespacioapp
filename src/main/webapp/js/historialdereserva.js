var idusuario = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    getUsuario().then(function () {

        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });

        getHistorialDeReservas(user.idusuario, false, "ASC");

        $("#aceptar-eliminar-reserva-btn").click(function () {
            let idreservaeliminar = $("#eliminar-reserva-modal").data("reservaPorEliminar");
            eliminarReserva(idreservaeliminar);
        });
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            idusuario: idusuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}



function getHistorialDeReservas(username, ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaListar",
        data: $.param({
            idusuario: username,
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarreserva(parsedResult);

                $(".btn-modificar-reserva").click(function (event) {
                    let idusuariorow = $(event.target).data("idusuario");
                    let idreservarow = $(event.target).data("idreserva");
                    location.href = 'modificarreserva.html?username=' + idusuariorow + '&idreserva=' + idreservarow;
                });
            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}
function mostrarreserva(reserva) {

    let contenido = "";

    $.each(reserva, function (index, reserva) {

        reserva = JSON.parse(reserva);

        let horarioReserva = "";

        if (reserva.horario == "1") {
            horarioReserva = "Mañana";
        } else if (reserva.horario == "2") {
            horarioReserva = "Tarde";
        } else {
            if (reserva.horario == "3")
                horarioReserva = "noche";
        }

        contenido +=
                '<tr><th scope="row">' + reserva.idreserva + '</th>' +
                '<td>' + reserva.username + '</td>' +
                '<td>' + reserva.fecha + '</td>' +
                '<td>' + horarioReserva + '</td>' +
                '<td>' + reserva.salonsocial + '</td>';
        
        let currentDate = new Date();
        let fechareserva = new Date(reserva.fecha);
        
        if(fechareserva >= currentDate) {
            contenido += '<td><button class="btn btn-warning btn-modificar-reserva" data-idreserva="' + reserva.idreserva + '" data-idusuario="' + idusuario + '" >Modificar</button> ' +
                    '<button onclick="prepararModalEliminarReserva(' + reserva.idreserva + ');" data-toggle="modal" data-target="#eliminar-reserva-modal" class="btn btn-danger" >Eliminar</button></td></tr>';
        } else {
            contenido += '<td><button disabled class="btn btn-warning btn-modificar-reserva" data-idreserva="' + reserva.idreserva + '" data-idusuario="' + idusuario + '" >Modificar</button> ' +
                    '<button disabled onclick="prepararModalEliminarReserva(' + reserva.idreserva + ');" data-toggle="modal" data-target="#eliminar-reserva-modal" class="btn btn-danger" >Eliminar</button></td></tr>';
        }
        
    });
    $("#reserva-tbody").html(contenido);
}

function prepararModalEliminarReserva(idreserva) {
    $("#eliminar-reserva-modal").data("reservaPorEliminar", idreserva);
}

function eliminarReserva(idreservaeliminar) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaEliminar",
        data: $.param({
            idreserva: idreservaeliminar,
        }),
        success: function (result) {

            let resultParsed = JSON.parse(result);
            $(window).scrollTop(0);
            $('#eliminar-reserva-modal').modal('toggle');
            if (resultParsed.resultado != false) {
                $("#accion-error").addClass("d-none");
                $("#accion-exito").removeClass("d-none");
            } else {
                $("#accion-error").removeClass("d-none");
                $("#accion-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}


