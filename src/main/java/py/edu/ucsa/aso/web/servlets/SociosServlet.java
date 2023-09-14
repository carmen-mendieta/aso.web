package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Servlet implementation class SociosServlet
 */


public class SociosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SociosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw= response.getWriter();
		pw.print("<html><head><title>Mostrar Parametros</title></head>");
		pw.print("<body><h1>Parametro</h1><hr>");
		if(Objects.nonNull(request.getParameter("nombres"))) {
			pw.print("<br>Nombres: " +request.getParameter("nombres"));
		}
		if(Objects.nonNull(request.getParameter("apellidos"))) {
			pw.print("<br>Apellidos: " +request.getParameter("apellidos"));
		}
		
		if(Objects.nonNull(request.getParameter("email"))) {
			pw.print("<br>Email: " +request.getParameter("email"));
		}
				
	}

}
