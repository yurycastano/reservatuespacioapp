/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelts;

import beans.ResultadoPeticion;
import com.google.gson.Gson;
import controller.ReservaController;
import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yuri9
 */
@WebServlet(name = "ServletCrearReserva", urlPatterns = {"/ServletCrearReserva"})
public class ServletCrearReserva extends HttpServlet {

    public ServletCrearReserva() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String result = null;

        ReservaController reservaController = new ReservaController();

        String idusuario = request.getParameter("idusuario");
        String fecha = request.getParameter("fecha");
        int horario = Integer.parseInt(request.getParameter("horario"));
        int salonsocial = Integer.parseInt(request.getParameter("salonsocial"));
        
        if(result == null) {
            result = reservaController.crear(idusuario, fecha, horario, salonsocial);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }


}
