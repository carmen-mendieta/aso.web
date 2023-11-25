package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dto.Opcion;
import py.edu.ucsa.aso.web.jdbc.dto.Socio;
import py.edu.ucsa.aso.web.jdbc.dto.Usuario;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Servlet implementation class SuspensionServlet
 */
@WebServlet("/suspension-servlet")
public class SuspensionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuspensionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Objects.isNull(request.getParameter("ACCION")) || "".equals(request.getParameter("ACCION"))) {

			if (Objects.isNull(request.getParameter("FORMATO")) || "HTML".equals(request.getParameter("FORMATO"))) {
				request.getRequestDispatcher("suspension-socio.jsp").forward(request, response);
			} else if ("JSON".equals(request.getParameter("FORMATO"))) {
				response.setContentType("application/json");
				if (Objects.isNull(request.getParameter("FILTRO"))) {
					List<Socio> sociosSuspensiones = DAOFactory.getSocioDAO().getListadoSocios("TODOS");
					System.out.println("maria: " + sociosSuspensiones.size());
					response.getWriter().print(JSONArray.fromObject(sociosSuspensiones));
				} else {
					response.getWriter().print(JSONArray
							.fromObject(DAOFactory.getSocioDAO().getListadoSocios(request.getParameter("FILTRO"))));
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("parametro:"+request.getParameter("ID"));

		int idSocio = 0;
		String observacion = "";
		int idUsuarioConectado = 0;
		HttpSession session = request.getSession(false);

		if ("SUSPENDER".equals(request.getParameter("ACCION"))) {
			if (Objects.nonNull(request.getParameter("ID"))) {
				idSocio = Integer.parseInt(request.getParameter("ID"));
			}

			if (Objects.nonNull(request.getParameter("OBSERVACIONINPUT"))) {
				observacion = request.getParameter("OBSERVACIONINPUT");
			}

			if (session != null) {
				Usuario usuarioConectado = (Usuario) session.getAttribute("USUARIO_CONECTADO");
				if (usuarioConectado != null) {
					idUsuarioConectado = usuarioConectado.getId();
					System.out.println("IdUsuario: " + idUsuarioConectado);
				}
			}
			try {
				if(idSocio>0 && !observacion.isEmpty() && idUsuarioConectado > 0) {
				DAOFactory.getSocioDAO().suspenderSocio(idSocio, observacion, idUsuarioConectado);
				request.getSession().setAttribute("TODOS", DAOFactory.getSocioDAO().getListadoSocios("TODOS"));
				request.getRequestDispatcher("suspension-socio.jsp").forward(request, response);
				}else {
					System.out.println("Alguna condicion no se cumple");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
