package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="/practica1_sesion1/index.html";
		
		HttpSession sesion = request.getSession(true);
		
		// Obtenemos el valor del parametro email rellenado en el formulario anterior
		String email = request.getParameter("email");
		
		// Asignamos el valor de email a la cookie emailCookie
		Cookie c = new Cookie("emailCookie", email);
		c.setMaxAge(60*60*24*365*2); // tiempo de permanencia en el cliente
		c.setPath("/");
		
		// Añadimos la Cookie a la respuesta
		response.addCookie(c);
		
		//Para eliminar la cookie:
				c.setMaxAge(0);
				c.setPath("/");
				response.addCookie(c);
		
		// Redireccionamos a index.html
		response.sendRedirect(url);

		
		
	}

}
