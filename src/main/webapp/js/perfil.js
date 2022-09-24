var idusuario = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario();

    $("#form-modificar").on("submit", function (event) {
        event.preventDefault();
        modificarUsuario();
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
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-cedula").val(parsedResult.cedula);
                $("#input-numerodetelefono").val(parsedResult.numerodetelefono);
                $("#input-email").val(parsedResult.email);
                $("#input-torre").val(parsedResult.torre);
                $("#input-apartamento").val(parsedResult.apartamento);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function modificarUsuario() {

    let username = $("#input-idusuario").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let cedula = $("#input-cedula").val();
    let numerodetelefono = $("#input-numerodetelefono").val();
    let email = $("#input-email").val();
    let torre = $("#input-torre").val();
    let apartamento = $("#input-apartamento").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            idusuario: username,
            contrasena: contrasena,
            nombre: nombre,
            apellidos: apellidos,
            cedula: cedula,
            numerodetelefono: numerodetelefono,
            email: email,
            torre: torre,
            apartamento: apartamento,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}



