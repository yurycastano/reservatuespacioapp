package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Reserva;
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

}