package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LeerCookie
 */
@WebServlet("/leer-cookie")
public class LeerCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeerCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// CREAMOS LA PAGINA HTML A SER ENVIADA AL BROWSER
		out.print("<html ><head><title>Leer Cookies</title></head>");
		// CONTENIDO QUE ENVIAMOS AL BODY
		out.print("<body><h1>Estamos leyendo cookies al navegador!!!</h1>");
		// OBTENEMOS LAS COOKIES DEL REQUEST
		if (request.getCookies() != null && request.getCookies().length > 0) {
			for (Cookie cookie : request.getCookies()) {
				// CON CADA COOKIE PODEMOS HACER ALGO ESPECIFICO
				if ("cookieUsuario".equals(cookie.getName())) {
					out.print("<h2>Nombre de la Cookie: " + cookie.getName() + "</h2><br/>");
					out.print("<h2>Valor de la Cookie: " + cookie.getValue() + "</h2><br/>");
				}
			}

		}

		// TERMINAMOS LA PAGINA HTML
		out.print("</body></html>");

	}

}
