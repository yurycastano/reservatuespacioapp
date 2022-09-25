var idusuario = new URL(location.href).searchParams.get("username");
var idreserva = new URL(location.href).searchParams.get("idreserva");
var reserva;

$(document).ready(function () {
    fillSalonesSociales().then(function () {
        fillReserva();
        $("#form-modificar-reserva").on("submit", function (event) {
            event.preventDefault();
            modificarReserva();
        });
    });

    

});

async function fillReserva() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaPedir",
        data: $.param({
            idreserva: idreserva,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                reserva = parsedResult;
                
                let fechajs = new Date(parsedResult.fecha);
                var year=fechajs.getFullYear();
                var month=fechajs.getMonth()+1;
                var day=fechajs.getDate();
                var formatted=year+"-"+month+"-"+day;

                $("#input-idusuario").val(idusuario);
                $("#input-idreserva").val(parsedResult.idreserva);
                $("#input-fecha").val(formatted);
                $("#input-horario").val(parsedResult.horario);
                $("#input-salonsocial").val(parsedResult.salonsocial);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

async function fillSalonesSociales() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletSalonSocialListar",
        data: $.param({
            idusuario: idusuario,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                listarSalonesSociales(parsedResult);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function listarSalonesSociales(salonesSocialesList) {

    let contenido = "";

    $.each(salonesSocialesList, function (index, salonsocial) {

        salonsocial = JSON.parse(salonsocial);

        contenido +=
                '<option value="' + salonsocial.salonsocial + '">' + salonsocial.nombre + ' [Aforo = ' + salonsocial.aforo + ' , Precio = ' + salonsocial.precio + ']  </option>';
    });
    $("#input-salonsocial").html(contenido);
}

function modificarReserva() {

    let idreserva = $("#input-idreserva").val();
    let username = $("#input-idusuario").val();
    let fecha = $("#input-fecha").val();
    let horario = $("#input-horario").val();
    let salonsocial = $("#input-salonsocial").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaModificar",
        data: $.param({
            idreserva: idreserva,
            idusuario: username,
            fecha: fecha,
            horario: horario,
            salonsocial: salonsocial
        }),
        success: function (result) {

            let resultParsed = JSON.parse(result);
            if (resultParsed.resultado != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");

                setTimeout(function () {
                    location.reload();
                }, 2000);
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

        }
    });

}


