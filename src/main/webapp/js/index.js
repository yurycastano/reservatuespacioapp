$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
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
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
