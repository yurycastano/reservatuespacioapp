package test;

import beans.Reserva;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionBD {
    public static void main (String[] args){
        listarReserva();
        
    }
    public static void actualizarReserva(int idreserva, String username){
        
        DBConnection con  = new DBConnection();
        String sql = "UPDATE reserva SET username = '" + username+"'WHERE ID="+ idreserva;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }finally{
            con.desconectar();
        }
        
    }
    public static void listarReserva(){
        DBConnection con  = new DBConnection();
        String sql = "select * from reserva";
        try {
            Statement st = con.getConnection().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               int idreserva = rs.getInt("idreserva");
               String username = rs.getString("username");
               Date fecha = rs.getDate("fecha");
               boolean horario = rs.getBoolean("horario");
               int salonsocial = rs.getInt("salonsocial");
               
               Reserva reserva = new Reserva(idreserva,username,fecha,horario,salonsocial);
               System.out.println(reserva.toString());
                      
           }          
          }catch (Exception ex){
              System.out.println(ex.getMessage());
          }finally{
            con.desconectar();
        }
    }
}
    

