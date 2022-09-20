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
}