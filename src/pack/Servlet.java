package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();

	    out.println("Cabeceras de petición:");
	    
	    /*Objeto names guarda la lista de cabeceras*/
	    Enumeration<String> names = request.getHeaderNames();
	    while (names.hasMoreElements()) {
	    	/*Variable name guarda el nombre de cabecera*/
	    	String name = (String) names.nextElement();
	    	/*Objeto values guarda la lista de valores de las cabeceras*/
	    	Enumeration<String> values = request.getHeaders(name); // Soporta múltiples valores
	    	if (values != null) {
	    		while (values.hasMoreElements()) {
	    			/*Variable value contiene el valor de cada cabecera*/
	    			String value = (String) values.nextElement();
	    			out.println(name + ": " + value);
	    			}
	    		}
	    	}
	    }
	}
