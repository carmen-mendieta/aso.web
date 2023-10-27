package py.edu.ucsa.aso.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.aso.web.jdbc.dao.DAOFactory;
import py.edu.ucsa.aso.web.jdbc.dao.OpcionDAO;
import py.edu.ucsa.aso.web.jdbc.dao.PagoCuotaDAO;
import py.edu.ucsa.aso.web.jdbc.dto.Opcion;
import py.edu.ucsa.aso.web.jdbc.dto.PagosCuotaSocios;
import py.edu.ucsa.aso.web.jdbc.dto.Socio;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Servlet implementation class PagoServlet
 */
@WebServlet("/pago-servlet")
public class PagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PagoCuotaDAO pagoDao = DAOFactory.getPagoCuotaDAO();
		
		if(Objects.isNull(request.getParameter("ACCION")) 
				  || "".equals(request.getParameter("ACCION"))
				  || "LISTAR".equals(request.getParameter("ACCION"))) {
				  List<PagosCuotaSocios> pagos= pagoDao.listar();
				  request.getSession().setAttribute("PAGOS", pagos);
				  request.getRequestDispatcher("listar-pagos.jsp").forward(request, response);
			  }else if("NUEVO".equals(request.getParameter("ACCION"))) {
				  System.out.println("NUEVO PAGO");
				  request.getSession().setAttribute("PAGOS", pagoDao.listar());
				  request.getRequestDispatcher("abm-socio.jsp").forward(request, response);
				} 
		
		/*
		 * if(Objects.isNull(request.getParameter("ACCION")) ||
		 * "".equals(request.getParameter("ACCION")) ||
		 * "LISTAR".equals(request.getParameter("ACCION"))) { List<PagosCuotaSocios>
		 * pago= pagoDao.listar(); request.getSession().setAttribute("PAGOS", pago);
		 * request.getRequestDispatcher("listar-pagos.jsp").forward(request, response);
		 * // }
		 */
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
