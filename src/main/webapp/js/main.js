var username = new URL(location.href).searchParams.get("username");

$(document).ready(function () {
    $("#boton-login").attr("href", "login.html");
     $("#boton-inicio").attr("href", "index.html?username=" + username);
     $("#boton-crear-reserva").attr("href", "crearreserva.html?username=" + username);
     $("#boton-historial-de-reservas").attr("href", "historialdereservas.html?username=" + username);
     
     $("#boton-reserva-aqui-card").attr("href", "crearreserva.html?username=" + username);
     $("#boton-elimina-reserva-card").attr("href", "historialdereservas.html?username=" + username);
     $("#boton-historial-de-reservas-card").attr("href", "historialdereservas.html?username=" + username);
     
     $("#boton-cerrar-sesion").click(function (event) {
        $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioCerrarSesion",
        data: $.param({
            idusuario: username
        }),
        success: function (result) {
            location.reload();
        }
    });
    });
     
});

