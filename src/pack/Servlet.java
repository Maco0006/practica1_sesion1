package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//Para solucionar el problema de la libreria JRE (al importar el proyecto desde github, no aparece):
//Project --> Properties --> Java Build Path.
//Selecciono la entrada JRE con error.
//Clic en el boton Edit.
//Selecciono un JRE alternativo.
//Boton a Finish.

//Ademas, despues me daba un error de servidor, por lo que aplique el siguiente cambio:
//Project --> Properties --> Java Build Path --> Libraries.
//Clic en Add External Jars.
//Selecciono la direcci�n: /Tomcat/Bin/tomcat-juli.jar.
//Aplicar cambios.



@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static final String NEW_HOST = ""; // Para cambiar el dominio y subdominio

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); // MUY IMPORTANTE EL TIPO PARA QUE NOS COJA LAS ETIQUETAS QUE USEMOS
	    PrintWriter out = response.getWriter();
	    String title = "HTTP Header Request Example";
	    out.println("<html>\n" + "<head><title>" + title + "</title></head>\n"
	    		+ "<body>\n");
	    
	    // Metodo getHeaderNames
	    out.println("<h1 align=\"center\"> Method GetHeaderNames </h1>\n"
	    		+ "<table width=\"100%\" border=\"1\" align=\"center\">\n"
	    		+ "<tr>\n"
	    		+ "<th>Header Name</th><th>Header Value</th>\n" + "</tr>\n");
	    
	    
	    // Objeto names guarda la lista de cabeceras
	    Enumeration<String> names = request.getHeaderNames();
	    while (names.hasMoreElements()) {
	    	// Variable name guarda el nombre de cabecera
	    	String name = (String) names.nextElement();
	    	// Objeto values guarda la lista de valores de las cabeceras
	    	Enumeration<String> values = request.getHeaders(name); // Soporta m�ltiples valores
	    	if (values != null) {
	    		while (values.hasMoreElements()) {
	    			/*Variable value contiene el valor de cada cabecera*/
	    			String value = (String) values.nextElement();
	    			out.println("<tr><td>" + name + "</td>\n<td>" + value + "</td></tr>\n");
	    			}
	    		}
	    	}
	    
	    // Metodo getHeader
	    out.println("</table>\n");
	    out.println("<h1 align=\"center\"> Method GetHeader </h1>\n"
	    		+ "<table width=\"100%\" border=\"1\" align=\"center\">\n"
	    		+ "<tr>\n"
	    		+ "<th>Header Name</th><th>Header Value</th>\n" + "</tr>\n");   
	    	    
	    // Seleccionamos una cabecera y guardamos su valor en la variable
	    String acceptLanguage = request.getHeader("accept-language");
	    String acceptCharset = request.getHeader("accept-charset");
	    // Mostramos el valor de la cabecera seleccionada
	    out.println("<tr><td>Accept-Language</td>\n<td>" + acceptLanguage + "</td></tr>\n");
	    out.println("<tr><td>Accept-Charset</td>\n<td>" + acceptCharset + "</td></tr>\n");
	    
	    out.println("</table>\n");
	    out.println("<h1 align=\"center\"> Method getAuthType </h1>\n"
	    		+ "<table width=\"100%\" border=\"1\" align=\"center\">\n"
	    		+ "<tr>\n"
	    		+ "<th>Name</th><th>Value</th>\n" + "</tr>\n");
	    
	    /* 
	    	Metodo getAuthType
	    	Devuelve el nombre del esquema de autenticacion utilizado para proteger el servlet. Todos los contenedores Servlet 
	    	admiten autenticacion basica, de formulario y de certificado de cliente, y tambien pueden admitir la autenticacion
	    	resumida. Si el servlet no esta autenticado, se devuelve null.
	    */
	    out.println("<tr><td>User name</td>\n<td>" + request.getRemoteUser() + "</td></tr>\n");
	    String name = (request.getUserPrincipal() == null) ? null : request.getUserPrincipal().getName();
	    out.println("<tr><td>Principal name</td>\n<td>" + name + "</td></tr>\n");
	    out.println("<tr><td>Authentication Type</td>\n<td>" + request.getAuthType() + "</td></tr>\n");
	    out.println("<tr><td>Is a Manager</td>\n<td>" + request.isUserInRole("manager") + "</td></tr>\n");
	    
	    out.println("</table>\n");
	    
	    
	    // Metodo getRequest URI
	    out.println("<h1 align=\"center\"> Method getRequestURI </h1>\n");
	    
	    //Genera una nueva localizacion del URI solicitado, que permite redireccionar cualquier peticion hecha a otro servidor
	    //a la misma direcci�n en el nuevo servidor.
	    
	    String newLocation = NEW_HOST + request.getRequestURI();
	    response.setHeader("Refresh", "10; URL=" + newLocation);
	    
	    out.println("The requested URI has been moved to a different host.<BR>");
	    out.println("Its new location is " + newLocation + "<BR>");
	    out.println("Your browser will take you there in 10 seconds.");
	    
	    out.println("</table>");
	    out.println("<br><br>");
	    out.println("<a href=\"/practica1_sesion1/index.html\">Volver</a>");
	    out.println("</body>\n</html>");
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response); // Llama al metodo doGet
		}
	
	}