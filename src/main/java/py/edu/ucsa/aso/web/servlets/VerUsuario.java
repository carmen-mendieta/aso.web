package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class VerUsuario
 */
@WebServlet("/ver-usuario")
public class VerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		out.print("<html >"
				+ "<head>"
				+ "    <title>USUARIO</title>"
				+ "</head>"
				+ "<body>");
		if(session!=null) {
			out.print("<h1>Nombre del Usuario:</h1><br>");
			
			if(session.getAttribute("usuario")!=null) {
				String usuario=(String) session.getAttribute("usuario");
				out.print("<br><h2>"+usuario+"</h2>");
			}
		}else {
			out.print("<h1>La aplicacion no obtuvo la sesion</h1>");
		}
		out.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
