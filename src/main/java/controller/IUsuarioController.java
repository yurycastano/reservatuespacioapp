package controller;
import java.util.Map;


public  interface IUsuarioController {
    
    public String login(String idusuario,String contrasena);
    
    public String register(String idusuario, String contrasena,
            String nombre, String apellidos, int cedula, String numerodetelefono,String email, String torre,String apartamento);
    
    public String pedir(String idusuario);
    
} 
