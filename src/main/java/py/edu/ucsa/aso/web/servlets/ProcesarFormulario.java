package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProcesarFormulario
 */

@WebServlet("/procesar-formulario")
public class ProcesarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1830982047267146140L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesarFormulario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><title>Mostrar Parametros </tile></head>");
		pw.print("<body><h1>Parametro</h1><hr>");

		if (request.getParameter("descripcion") != null) {
			pw.print("<br>descripcion: " + request.getParameter("descripcion"));
		}

		if (request.getParameter("contrasena") != null) {
			pw.print("<br>contrasena: " + request.getParameter("contrasena"));
		}

	}

}
