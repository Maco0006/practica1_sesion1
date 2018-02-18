package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.Date; // Libreria necesaria para usar objetos Date

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Para iniciar una sesión en un servlet simplemente se crea un objeto
		   del tipo HttpSession llamando al método getSession() de una Request:
		   Es equivalente HttpSession session = request.getSession(true), que
		   devuelve el objeto sesión si ya existe, o en caso contrario lo crea nuevo.
		*/
		HttpSession sesion = request.getSession(true);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = "HTTP Session Cookies Example";
		out.println("<html>\n" + "<head><title>" + title + "</title></head>\n"
	    		+ "<body>\n<h1> Control de acceso </h1>\n");
		out.println("<strong>\n");
		
	    // Cookie de sesion - fecha
		Date date = (Date)sesion.getAttribute("date");
	    if(date != null) {
	    	out.println("Último acceso de la sesión: " + date +"<br>\n");
	    }
	    else{
	    	out.println("Este es el primer acceso de la sesión.<br>\n");
	    }
	    date = new Date();
	    sesion.setAttribute("date", date);
	    out.println("Fecha actual: " + date + "<br>\n");
	    out.println("</strong>\n");
	    
	    // Cookie de sesion - temporizador de sesion
	    out.println("<h1>Temporizador de Sesión</h1>");
	    out.println("El tiempo de espera anterior fue " + sesion.getMaxInactiveInterval() + " segundos");
	    out.println("<br>");
	    
	    sesion.setMaxInactiveInterval(60); // el valor es en segundos
	    out.println("El nuevo tiempo de espera asignado es " + sesion.getMaxInactiveInterval() + " segundos");
	    out.println("<br><br>");
	    out.println("<a href=\"/practica1_sesion1/index.html\">Volver</a>");
	    out.println("</body>\n</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
