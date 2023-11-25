package py.edu.ucsa.aso.web.filtros;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dto.Rol;
import py.edu.ucsa.aso.web.jdbc.dto.Usuario;

/**
 * Servlet Filter implementation class SuspensionFilter
 */
@WebFilter("/suspension-servlet")
public class SuspensionFilter extends HttpFilter implements Filter {
	private HttpServletRequest httpRequest;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public SuspensionFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		if (session != null) {
			Usuario usuarioLogueado = (Usuario) session.getAttribute("USUARIO_CONECTADO");
			List<Rol> roles = DAOFactory.getUsuarioDAO().getRolesByUsuario(usuarioLogueado.getId());
			
			for(Rol rol: roles) {
				
				System.out.println(rol);
			}
			boolean tieneRolAdmin = roles.stream().anyMatch(rol -> rol.getNombreRol().trim().equals("ADMIN"));
		   System.out.println("tieneRolAdmin"+ tieneRolAdmin);
			boolean tieneRolSuspension = roles.stream().anyMatch(rol -> rol.getNombreRol().trim().equals("SUSPENSION"));
			System.out.println("tieneRolSuspension"+ tieneRolSuspension);
			if (tieneRolAdmin && tieneRolSuspension) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403, "No tiene permisos");
			}

		} else {
			request.getRequestDispatcher("loginUsuario.jsp").forward(request, response);
		}

	}



	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
