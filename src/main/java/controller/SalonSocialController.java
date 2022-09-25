/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.SalonSocial;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuri9
 */
public class SalonSocialController implements ISalonSocialController {
    
    @Override
    public String listar() {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM salon_social";



        List<String> salonSocialList = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idsalonsocial = rs.getInt("idsalonsocial");
                String nombre = rs.getString("nombre");
                int aforo = rs.getInt("aforo");
                double precio = rs.getDouble("precio");


                SalonSocial salonSocial = new SalonSocial(idsalonsocial,nombre,aforo,precio);

                salonSocialList.add(gson.toJson(salonSocial));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(salonSocialList);

    }
}
