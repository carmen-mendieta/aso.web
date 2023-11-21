package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dao.UsuarioDAO;
import py.edu.ucsa.aso.web.jdbc.dto.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		
		Usuario usuario= DAOFactory.getUsuarioDAO().autenticar( request.getParameter("usuario"), request.getParameter("clave"));
		if(Objects.isNull(usuario)) {
			request.getRequestDispatcher("loginUsuario.jsp").forward(request, response);
			
		}else {
			request.getSession(true).setAttribute("SOCIO_CONECTADO", usuario);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} 
		
		
//		PrintWriter pw = response.getWriter();

//		String usuario = null;
//		String clave = null;
//		if (Objects.nonNull(request.getParameter("usuario"))) {
//			usuario = request.getParameter("usuario");
//		}
//
//		if (Objects.nonNull(request.getParameter("clave"))) {
//			clave = request.getParameter("clave");
//		}
//		 if (usuario !=null && clave != null ) {
//			 
//			 Usuario usuariodto = DAOFactory.getUsuarioDAO().Autenticar(usuario, clave);
//			 if (Objects.nonNull(usuariodto)) {
//				 // OBTENEMOS EL OBJETO QUE MANEJA LA SESSION
//				 HttpSession session = request.getSession(true);
//				 
//				 session.setAttribute("usuario", usuariodto);
//				 
//				 pw.print("<body><h1>Bienvenido/a:" + usuariodto.getEmail() + " </h1><hr>");
//				 
//			 } else {
//				 
//				// pw.print("<body><h1>Usuario no encontrado</h1><hr>");
//				 request.setAttribute("errorMensaje", "Usuario no encontrado");
//				    request.getRequestDispatcher("/login.jsp").forward(request, response);
//				}
//			 
//		 }else {
//			 pw.print("<body>Complete los campos requeridos <h1></h1><hr>");
//		 }

		/*
		 * if(request.getParameter("clave")!=null) { session.setAttribute("clave",
		 * request.getParameter("clave")); }
		 */

	}

}
