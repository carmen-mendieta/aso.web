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
@WebServlet("/socio-servlet")
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
		
		if(Objects.nonNull(request.getParameter("nroSocio"))) {
			pw.print("<br>Numero de Socio: " +request.getParameter("nroSocio"));
		}
		
		if(Objects.nonNull(request.getParameter("nroCedula"))) {
			pw.print("<br>Numero de Cedula: " +request.getParameter("nroCedula"));
		}
		
		if(Objects.nonNull(request.getParameter("fechaIngreso"))) {
			pw.print("<br>Fecha de Ingreso: " +request.getParameter("fechaIngreso"));
		}
		
		if(Objects.nonNull(request.getParameter("estadoActual"))) {
			pw.print("<br>Estado: " +request.getParameter("estadoActual"));
		}
		
		if(Objects.nonNull(request.getParameter("fundador"))) {
			pw.print("<br> Es fundador: " +request.getParameter("fundador"));
		}
		
		if(Objects.nonNull(request.getParameter("usuarioCreacion"))) {
			pw.print("<br>Usuario Creacion: " +request.getParameter("usuarioCreacion"));
		}
		
		if(Objects.nonNull(request.getParameter("fechaCreacion"))) {
			pw.print("<br>Fecha de Creacion: " +request.getParameter("fechaCreacion"));
		}
		
		if(Objects.nonNull(request.getParameter("socioProponente"))) {
			pw.print("<br>Socio Proponente: " +request.getParameter("socioProponente"));
		}
		
		if(Objects.nonNull(request.getParameter("tipoSocio"))) {
			pw.print("<br>Tipo Socio: " +request.getParameter("tipoSocio"));
		}
				
	}

}