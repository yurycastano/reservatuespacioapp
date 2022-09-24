package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String idusuario, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where idusuario= '" + idusuario
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int cedula= rs.getInt("cedula");
                String telefono= rs.getString("telefono");
                String email = rs.getString("email");
                String torre = rs.getString("torre");
                String apartamento = rs.getString("apartamento");
                
               

                Usuario usuario
                        = new Usuario(idusuario, contrasena, nombre, apellidos,cedula,telefono, email, torre, apartamento);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
     @Override
    public String register(String idusuario, String contrasena, String nombre, String apellidos, int cedula, String numerodetelefono, String email,
            String torre,String apartamento) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + idusuario + "', '" + contrasena + "', '" + nombre
                + "', '" + apellidos + "', '" + cedula +"', '" + numerodetelefono +"', '" + email + "', '" + torre + "', '" + apartamento+ "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(idusuario, contrasena, nombre, apellidos, cedula,numerodetelefono,email, torre, apartamento);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String idusuario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where idusuario = '" + idusuario + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int cedula = rs.getInt("cedula");
                String numerodetelefono = rs .getString("telefono");
                String email = rs.getString("email");
                String torre =rs.getString("torre");
                String apartamento =rs.getString("apartamento");
                Usuario usuario = new Usuario(idusuario, contrasena,
                        nombre, apellidos,cedula,numerodetelefono, email, torre,apartamento);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(String idusuario, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos, int nuevaCedula, String numerodetelefono, String nuevoEmail, 
            String nuevaTorre, String nuevoApartamento) {   

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + nuevaContrasena + "', "
                + "nombre = '" + nuevoNombre + "', "
                + "cedula = '" + nuevaCedula + "', "
                + "telefono = '" + numerodetelefono + "', "
                + "apellidos=  '" + nuevosApellidos + "', email = '" 
                + nuevoEmail + "', torre = '" + nuevaTorre + "', apartamento = '" + nuevoApartamento + "'";

        sql += " where idusuario = '" + idusuario + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
  }


