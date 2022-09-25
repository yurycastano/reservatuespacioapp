package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Reserva;
import beans.ResultadoPeticion;
import beans.Usuario;
import connection.DBConnection;

public class ReservaController implements IReservaController {

    @Override
    public String listar(String username, boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM reserva WHERE username = '" + username + "'";

        if (ordenar == true) {
            sql += " order by fecha " + orden;
        }

        List<String> reservaList = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idreserva = rs.getInt("idreserva");
                String usernameBd = rs.getString("username");
                Date fecha = rs.getDate("fecha");
                int horario = rs.getInt("horario");
                int salonsocial= rs.getInt("salonsocial");

                Reserva reserva = new Reserva(idreserva, usernameBd, fecha, horario, salonsocial);

                reservaList.add(gson.toJson(reserva));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(reservaList);

    }

    @Override
    public String crear(String idusuario, String fecha, int horario, int salonsocial) {
        
        
         Gson gson = new Gson();
         ResultadoPeticion resultadoPeticion = new ResultadoPeticion();
         
         DBConnection conexion = new DBConnection();
         
        String sqlSelect = "SELECT * FROM reserva where fecha='" + fecha + "' and salonsocial =" + salonsocial;
        
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            
            while (rs.next()) {

                int horarioReserva = rs.getInt("horario");
                if(horarioReserva == horario) {
                    resultadoPeticion.setResultado(false);
                    resultadoPeticion.setMensaje("El horario no está disponbile");
                    return gson.toJson(resultadoPeticion);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultadoPeticion.setResultado(false);
            resultadoPeticion.setMensaje("Error en la conexión a la BD");
            return gson.toJson(resultadoPeticion);
        } finally {
            conexion.desconectar();
        }
         

        DBConnection con = new DBConnection();
        String sql = "Insert into reserva (username,fecha,horario,salonsocial) values('" + idusuario + "', '" + fecha + "', '" + horario
                + "', '" + salonsocial + "')";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultadoPeticion.setResultado(false);
            resultadoPeticion.setMensaje("Error ingresando la reserva a la BD");
            return gson.toJson(resultadoPeticion);
        } finally {
            con.desconectar();
        }
        
        resultadoPeticion.setResultado(true);
        resultadoPeticion.setMensaje("Reserva creada satisfactoriamente!");
        return gson.toJson(resultadoPeticion);
    }

    @Override
    public String pedir(String idreserva) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from reserva where idreserva = '" + idreserva + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idreservabd = rs.getInt("idreserva");
                String usernameBd = rs.getString("username");
                Date fecha = rs.getDate("fecha");
                int horario = rs.getInt("horario");
                int salonsocial= rs.getInt("salonsocial");

                Reserva reserva = new Reserva(idreservabd, usernameBd, fecha, horario, salonsocial);

                return gson.toJson(reserva);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(String idreserva, String idusuario, String fecha,int horario,int salonsocial) {
       
        DBConnection con = new DBConnection();

        String sql = "Update reserva set fecha = '" + fecha + "', "
                + "horario = '" + horario + "', "
                + "salonsocial = '" + salonsocial + "' ";

        sql += " where idreserva = '" + idreserva + "'";

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

    @Override
    public String eliminar(String idreserva) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "DELETE from reserva where idreserva = '" + idreserva + "'";
       
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