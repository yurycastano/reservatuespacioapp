/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelts;

import controller.ReservaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yuri9
 */
@WebServlet(name = "ServletReservaModificar", urlPatterns = {"/ServletReservaModificar"})
public class ServletReservaModificar extends HttpServlet {

    public ServletReservaModificar() {
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ReservaController reservaController = new ReservaController();

        String idreserva = request.getParameter("idreserva");
        String idusuario = request.getParameter("idusuario");
        String fecha = request.getParameter("fecha");
        int horario = Integer.parseInt(request.getParameter("horario"));
        int salonsocial = Integer.parseInt(request.getParameter("salonsocial"));

        String usuarioStr = reservaController.modificar(idreserva,idusuario,fecha,horario,salonsocial);
        PrintWriter out = response.getWriter();
        out.println(usuarioStr);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
