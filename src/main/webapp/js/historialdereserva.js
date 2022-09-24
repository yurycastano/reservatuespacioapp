var idusuario = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    getUsuario().then(function () {
        
        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });

        getHistorialDeReservas(user.idusuario,false, "ASC");

        //$("#ordenar-fecha").click(ordenarreserva);
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



function getHistorialDeReservas(username,ordenar, orden) {

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
            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}
function mostrarreserva(reserva) {

    let contenido = "";

    $.each(reserva, function (index,reserva) {

        reserva = JSON.parse(reserva);
        
        let horarioReserva = "";
        
        if(reserva.horario == "1") {
            horarioReserva = "Mañana";
        } else if(reserva.horario == "2") {
            horarioReserva = "Tarde";
        } else {
            if(reserva.horario == "3")
             horarioReserva = "noche";
        }

            contenido += 
                    '<tr><th scope="row">' + reserva.idreserva + '</th>' +
                    '<td>' + reserva.username + '</td>' +
                    '<td>' + reserva.fecha+ '</td>' +
                    '<td>' + horarioReserva + '</td>' +
                    '<td>' + reserva.salonsocial + '</td>';
        
    });
    $("#reserva-tbody").html(contenido);
}



