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
 * Servlet implementation class HolaDiplo
 */
@WebServlet(
		description = "Primer servlet",
		urlPatterns = {"/HolaDiplo","/PrimerServlet"
})

public class HolaDiplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaDiplo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		writer.print("<html><head><title>Servlet de Bienvenida!!</title></head>");
		writer.print("<body><h1>Bienvenidos al Diplomado!<h1><br>");
		
		if(Objects.nonNull(request.getParameter("parameter")))  {
			writer.print("<h3>Modulo:" +request.getParameter("param") +"</h3");
		}
		writer.print("</body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
