<%-- 
    Document   : index
    Created on : 7/09/2022, 10:26:03 a. m.
    Author     : yuri9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">
        <title>Página de inicio de sesión</title>
        <link rel="icon" href= "img/apartamento.png"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
        <div class=" container container-login  col-lg-3">
            <form action="principal">
                <div class="form-group text-center">
                    <img src="img/user_login.png" hiddean="80"width="80"/>
                    <p><strong> Bienvenido a reserva tu espacio App</strong></p>   
                </div>
                <div class="form-group">
                    <label>Usuario:</label>
                    <input type="usuario"name="txtusu" placeholder="Ingrese el usuario" class="form-control"/>
                </div>


                <div class="form-group">
                    <label> Contraseña:</label>
                    <input type="contraseña" name="txtcon" placeholder="Ingrese la contraseña"class="form-control"/>
                </div>
                
                <div class="row mt-3">
                    <div class="col-6"><button class="btn btn-secondary btn-block col-12" type="submit">Iniciar Sesión</button>  </div>
                    <div class="col-6"><button class="btn btn-secondary btn-block col-12" type="submit">Nuevo usuario</button></div>
                    
                </div>
            </form>
            

        </div>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
        crossorigin="anonymous"></script>
    </body>

</html>
