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
	    Enumeration<String> names = request.getHeaderNames();
	    while (names.hasMoreElements()) {
	      String name = (String) names.nextElement();
	      Enumeration<String> values = request.getHeaders(name); // support multiple values
	      if (values != null) {
	        while (values.hasMoreElements()) {
	          String value = (String) values.nextElement();
	          out.println(name + ": " + value);
	        }
	      }
	    }
	}
}
