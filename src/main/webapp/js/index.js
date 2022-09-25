$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });

    $("#nuevo-usuario-registrar").click(function (event) {
        location.href = 'register.html';
    });

});



function autenticarUsuario() {

    let usuario = $("#idusuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            idusuario: usuario,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['idusuario'];
                document.location.href = "index.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let idusuario = $("#input-idusuario").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let cedula = $("#input-cedula").val();
    let numerodetelefono = $("#input-numerodetelefono").val();
    let email = $("#input-email").val();
    let torre = $("#input-torre").val();
    let apartamento = $("#input-apartamento").val();


    if (contrasena == contrasenaConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                idusuario: idusuario,
                contrasena: contrasena,
                nombre: nombre,
                apellidos: apellidos,
                cedula: cedula,
                numerodetelefono: numerodetelefono,
                email: email,
                torre: torre,
                apartamento: apartamento

            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let idusuario = parsedResult['idusuario'];
                    document.location.href = "index.html?username=" + idusuario;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}