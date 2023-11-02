package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dao.OpcionDAO;
import py.edu.ucsa.aso.web.jdbc.dto.Opcion;
import py.edu.ucsa.aso.web.jdbc.dto.Dominio;


import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Servlet implementation class OpcionesServlet
 */
@WebServlet("/opcion-servlet")
public class OpcionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpcionesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OpcionDAO opcionesDao = DAOFactory.getOpcionDAO();
		 if(Objects.isNull(request.getParameter("ACCION")) 
				  || "".equals(request.getParameter("ACCION"))
				  || "LISTAR".equals(request.getParameter("ACCION"))) {
				  List<Opcion> opcion= opcionesDao.listar();
				  request.getSession().setAttribute("OPCIONES", opcion);
				  request.getRequestDispatcher("listar-opciones.jsp").forward(request, response);
//		
		 }	else if("NUEVO".equals(request.getParameter("ACCION"))) {
			  System.out.println("NUEVA OPCION");
			 request.getSession().setAttribute("OPCIONES",opcionesDao.listar());
			  request.getSession().setAttribute("DOMINIOS", DAOFactory.getDominioDAO().listar());
			  request.getSession().setAttribute("OPADRE", DAOFactory.getOpcionDAO().listar());
		     request.getRequestDispatcher("abm-opcion.jsp").forward(request, response);  
		   
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if("INSERTAR".equals(request.getParameter("ACCION"))) { 
		 
		OpcionDAO opcionesDao = DAOFactory.getOpcionDAO();
		Opcion dto = new Opcion();
		
		if (Objects.nonNull(request.getParameter("codigo"))) {
			dto.setCodigo(request.getParameter("codigo"));
		}
		
		if (Objects.nonNull(request.getParameter("descripcion"))) {
			dto.setDescripcion(request.getParameter("descripcion"));
		}
		
		if (Objects.nonNull(request.getParameter("estado"))) {
			dto.setEstado(request.getParameter("estado"));
		}
		
		if (Objects.nonNull(request.getParameter("dominio"))) {
			Dominio domi = new Dominio();
			domi.setId(Integer.parseInt(request.getParameter("dominio")));
			dto.setDominio(domi);
		}
		
		if (Objects.nonNull(request.getParameter("opcionPadre")) && !"".equals(request.getParameter("opcionPadre"))) {
			Opcion opadre = new Opcion();
			opadre.setId(Integer.parseInt(request.getParameter("opcionPadre")));
			dto.setOpcionPadre(opadre);
		}
		
		
		try {
		    opcionesDao.insertar(dto);
		    request.getSession().setAttribute("OPCIONES", opcionesDao.listar());
		    request.getRequestDispatcher("listar-opciones.jsp").forward(request, response);  // Redirige a la página de listado después de la inserción
		} catch (Exception e) {
		    e.printStackTrace();  
		   
		    response.sendRedirect("error-page.jsp");
		}
		
		}else if ("EDITAR".equals(request.getParameter("ACCION"))) {
			Opcion dto= DAOFactory.getOpcionDAO().getById(Integer.parseInt(request.getParameter("ID")));
			request.getSession().setAttribute("OPCION", dto);
			
			
		}else if ("ELIMINAR".equals(request.getParameter("ACCION"))) {
			System.out.println("ELIMINAMOS EL REGISTRO");
		//	DAOFactory.getOpcionDAO().eliminar(Integer.parseInt(request.getParameter("ID")));
			
		}
		
	}
	
	 
}
