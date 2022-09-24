var idusuario = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario();
    fillSalonesSociales();

    $("#form-crear-reserva").on("submit", function (event) {
        event.preventDefault();
        crearReserva();
    });

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            idusuario: idusuario,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-idusuario").val(parsedResult.idusuario);

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
                '<option value="' + salonsocial.salonsocial + '">' + salonsocial.nombre + '</option>'
    });
    $("#input-salonsocial").html(contenido);
}

function crearReserva() {

    let username = $("#input-idusuario").val();
    let fecha = $("#input-fecha").val();
    let horario = $("#input-horario").val();
    let salonsocial = $("#input-salonsocial").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletCrearReserva",
        data: $.param({
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
                $("#modificar-exito").html(resultParsed.mensaje);

                setTimeout(function () {
                    location.reload();
                }, 2000);
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-error").html(resultParsed.mensaje);
                $("#modificar-exito").addClass("d-none");
            }

        }
    });

}


