/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelts;

import controller.ReservaController;
import controller.UsuarioController;
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
@WebServlet(name = "ServletReservaEliminar", urlPatterns = {"/ServletReservaEliminar"})
public class ServletReservaEliminar extends HttpServlet {

    public ServletReservaEliminar() {
    }

   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReservaController reservaController = new ReservaController();
		
		String idreserva = request.getParameter("idreserva");
		
		String eliminarBoolean = reservaController.eliminar(idreserva);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(eliminarBoolean);
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
