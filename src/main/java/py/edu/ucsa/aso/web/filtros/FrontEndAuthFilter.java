package py.edu.ucsa.aso.web.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FrontEndAuthFilter
 */
public class FrontEndAuthFilter extends HttpFilter implements Filter {
	private HttpServletRequest httpRequest;
	
	 private static final String[] loginRequiredURLs = {
	            "/opcion-servlet", "/listar-opciones", "/abm-opcion"
	    };
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FrontEndAuthFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		httpRequest = (HttpServletRequest) request;
		 
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
 
        if (path.startsWith("/admin/")) {
            chain.doFilter(request, response);
            return;
        }
		HttpSession session = httpRequest.getSession(false);
		 
        boolean isLoggedIn = (session != null && session.getAttribute("SOCIO_CONECTADO") != null);
        System.out.println("httpRequest.getContextPath() = " + httpRequest.getContextPath());
        String loginURI = httpRequest.getContextPath() + "/login-servlet";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("loginUsuario.jsp");
 
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpRequest.getRequestDispatcher("/").forward(request, response);
 
        } else if (!isLoggedIn && isLoginRequired()) {
        	System.out.println("POR ACA ENTRAMOS");
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            String loginPage = "/loginUsuario.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        } else {
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
            chain.doFilter(request, response);
        }
	}
	
	private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
 
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
 
        return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
