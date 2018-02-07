package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    
	    String title = "HTTP Header Request Example";
	    String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
	    out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
	    		+ "<body>\n<h1 aling=\"center\">" + title + "</h1>\n"
	    		+ "<table width=\"100%\" border=\"1\" align=\"center\">\n"
	    		+ "<tr>\n"
	    		+ "<th>Header Name</th><th>Header Value</th>\n" + "</tr>\n");
	    //out.println("Cabeceras de petición");
	    // Metodo getHeaderNames
	    // Objeto names guarda la lista de cabeceras
	    Enumeration<String> names = request.getHeaderNames();
	    while (names.hasMoreElements()) {
	    	// Variable name guarda el nombre de cabecera
	    	String name = (String) names.nextElement();
	    	// Objeto values guarda la lista de valores de las cabeceras
	    	Enumeration<String> values = request.getHeaders(name); // Soporta múltiples valores
	    	if (values != null) {
	    		while (values.hasMoreElements()) {
	    			/*Variable value contiene el valor de cada cabecera*/
	    			String value = (String) values.nextElement();
	    			out.println("<tr><td>" + name + "</td>\n<td>" + value + "</td></tr>\n");
	    			}
	    		}
	    	}
	    out.println("</table>\n</body></html>");
	    /* IMPORTANTE!!! NO ME COGE LAS ETIQUETAS HTML, PERO ESTÁN BIEN ESCRITAS -.-"!
	     * PARA COMPROBAR: EJECUTA EL SERVLET COPIA EL CODIGO QUE SALE, PEGALO EN UN
	     * DOCUMENTO HTML Y EJECUTALO EN EL NAVEGADOR, SALDRÁ EL RESULTADO COMO ESPERAMOS.
	     */
	    
	    // Metodo getHeader
	    // Seleccionamos una cabecera y guardamos su valor en la variable
	    String acceptLanguage = request.getHeader("accept-language");
	    String acceptCharset = request.getHeader("accept-charset");
	    // Mostramos el valor de la cabecera seleccionada
	    out.println("\nacceptLanguage: " + acceptLanguage);
	    out.println("acceptCharset:" + acceptCharset);
	    }
	}
