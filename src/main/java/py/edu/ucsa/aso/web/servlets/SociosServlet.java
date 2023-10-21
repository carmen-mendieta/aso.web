package py.edu.ucsa.aso.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dao.SocioDAO;
import py.edu.ucsa.aso.web.jdbc.dto.Opcion;
import py.edu.ucsa.aso.web.jdbc.dto.Socio;
import py.edu.ucsa.aso.web.jdbc.dto.Usuario;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SocioDAO socioDAO = DAOFactory.getSocioDAO();
	  if(Objects.isNull(request.getParameter("ACCION")) 
		  || "".equals(request.getParameter("ACCION"))
		  || "LISTAR".equals(request.getParameter("ACCION"))) {
		  List<Socio> socios= socioDAO.listar();
		  request.getSession().setAttribute("SOCIOS", socios);
		  request.getRequestDispatcher("listar-socio.jsp").forward(request, response);
	  }else if("NUEVO".equals(request.getParameter("ACCION"))) {
		  System.out.println("NUEVO SOCIO");
		  request.getSession().setAttribute("SOCIOS", socioDAO.listar());
		  request.getSession().setAttribute("ESTADOS_SOCIOS", DAOFactory.getOpcionDAO().getOpcionesByCodDominio("ESTSOC"));
		  request.getSession().setAttribute("TIPOS_SOCIOS", DAOFactory.getOpcionDAO().getOpcionesByCodDominio("TIPSOC"));
		  request.getRequestDispatcher("abm-socio.jsp").forward(request, response);
	  }else if("INSERTAR".equals(request.getParameter("ACCION"))) {
		  System.out.println("VAMOS A INSERTAR EL NUEVO SOCIO");
		  Socio nuevo= new Socio();
		  nuevo.setNombres(request.getParameter("nombres"));
		  nuevo.setApellidos(request.getParameter("apellidos"));
		  nuevo.setEmail(request.getParameter("email"));
		  nuevo.setNroSocio(Integer.parseInt(request.getParameter("nroSocio")));
		  nuevo.setNroCedula(Integer.parseInt(request.getParameter("nroCedula")));
		  LocalDateTime ahora = LocalDateTime.now();
		  nuevo.setFechaIngreso(ahora);
		  Opcion estado = new Opcion();
		  estado.setId(Integer.parseInt(request.getParameter("estadoActual")));
		  nuevo.setEstadoActual(estado);
		  nuevo.setFundador(request.getParameter("fundador") != null && "on".equals(request.getParameter("fundador")));
		  Socio socio = new Socio();
		  socio.setId(Integer.parseInt(request.getParameter("socioProponente")));
		  nuevo.setSocioPoponente(socio);
		  Opcion tipoSocio = new Opcion();
		  tipoSocio.setId(Integer.parseInt(request.getParameter("tipoSocio")));
		  nuevo.setTipoSocio(tipoSocio);
		  request.setAttribute("MENSAJE", "EL SOCIO HA SIDO GUARDADO CON EXITO");
	      request.getSession().setAttribute("SOCIOS", socioDAO.listar()); 
	 	  request.getRequestDispatcher("listar-socio.jsp").forward(request, response);
	  
	  }
	  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SocioDAO socioDAO = DAOFactory.getSocioDAO();
		Socio dto = new Socio();

		if (Objects.nonNull(request.getParameter("apellidos"))) {
			dto.setApellidos(request.getParameter("apellidos"));
		}

		if (Objects.nonNull(request.getParameter("nombres"))) {
			dto.setNombres(request.getParameter("nombres"));
		}

		if (Objects.nonNull(request.getParameter("estadoActual"))) {
			Opcion estado = new Opcion();
			estado.setId(Integer.parseInt(request.getParameter("estadoActual")));
			dto.setEstadoActual(estado);
		}

		LocalDateTime ahora = LocalDateTime.now();
		dto.setFechaCreacion(ahora);
		dto.setFechaEstadoActual(ahora);
		dto.setFechaIngreso(ahora);

		if (Objects.nonNull(request.getParameter("fundador")) && "on".equals(request.getParameter("fundador"))) {
			dto.setFundador(true);

		} else {
			dto.setFundador(false);
		}
		if (Objects.nonNull(request.getParameter("email"))) {
			dto.setEmail(request.getParameter("email"));
		}

		if (Objects.nonNull(request.getParameter("nroCedula"))) {
			dto.setNroCedula(Integer.parseInt(request.getParameter("nroCedula")));
		}

		if (Objects.nonNull(request.getParameter("nroSocio"))) {
			dto.setNroSocio(Integer.parseInt(request.getParameter("nroSocio")));
		}

		if (Objects.nonNull(request.getParameter("tipoSocio"))) {
			Opcion tipoSocio = new Opcion();
			tipoSocio.setId(Integer.parseInt(request.getParameter("tipoSocio")));
			dto.setTipoSocio(tipoSocio);
		}

		dto.setUsuarioCreacion(new Usuario(1));
		socioDAO.insertar(dto);


		
		

		/*
		 * if (Objects.nonNull(request.getParameter("fechaIngreso"))) {
		 * pw.print("<br>Fecha de Ingreso: " + request.getParameter("fechaIngreso")); }
		 * 
		 * if (Objects.nonNull(request.getParameter("usuarioCreacion"))) {
		 * pw.print("<br>Usuario Creacion: " + request.getParameter("usuarioCreacion"));
		 * }
		 * 
		 * if (Objects.nonNull(request.getParameter("fechaCreacion"))) {
		 * pw.print("<br>Fecha de Creacion: " + request.getParameter("fechaCreacion"));
		 * }
		 * 
		 * if (Objects.nonNull(request.getParameter("socioProponente"))) {
		 * pw.print("<br>Socio Proponente: " + request.getParameter("socioProponente"));
		 * }
		 * 
		 * if (Objects.nonNull(request.getParameter("tipoSocio"))) {
		 * pw.print("<br>Tipo Socio: " + request.getParameter("tipoSocio")); }
		 */

	}

}
