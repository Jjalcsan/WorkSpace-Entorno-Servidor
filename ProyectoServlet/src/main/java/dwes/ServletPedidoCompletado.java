package dwes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletPedidoCompletado")
public class ServletPedidoCompletado extends HttpServlet{

	
	/**
	 * El metodo doGet primero mirará que exista la sesión. Si existe, completará el pedido y nos llevará al login 
	 * de nuevo invalidando la sesión e informando de que el pedido ha sido completado.
	 * Si la sesion no existe nos llevará al login con el correspondiente mensaje de que es necesario autenticarse
	 */
	public void doGet(HttpServletRequest request,
			  HttpServletResponse response)
			  throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sesion = request.getSession();
		
		if(sesion.getAttribute("nombre")==null) { //Si la sesion no existe nos devuelve al login
			
			out.println ("<html>");
		    out.println ("<body>");
		    out.println ("<div>");
		    out.println ("<h2>Iniciar sesion</h2>");
		    out.println ("<form action=\"/ProyectoServlet/servletLogin\" method=\"POST\">");
		    out.println ("<label for=\"nombre\">Nombre:</label>");
		    out.println ("<input type=\"text\" name=\"name\"><br>");
		    out.println ("<label for=\"contra\">ContraseÃ±a:</label>");
		    out.println ("<input type=\"password\" name=\"pass\"><br>");
		    out.println ("<p style=\"color:#FF0000\";>Debes iniciar sesion para entrar<p>");
		    out.println ("<input type=\"submit\" value=\"enviar\">");
		    out.println ("</form>");
		    out.println ("</div>");
		    out.println ("</body>");
		    out.println ("</html>");
			
		} else { // Si la sesion existe completará el pedido e invalidará la sesion
		
			sesion.invalidate();
			out.println ("<html>");
			out.println ("<body>");
			out.println ("<div>");
			out.println ("<h2>Iniciar sesion</h2>");
			out.println ("<form action=\"/ProyectoServlet/servletLogin\" method=\"POST\">");
			out.println ("<label for=\"nombre\">Nombre:</label>");
			out.println ("<input type=\"text\" name=\"name\"><br>");
			out.println ("<label for=\"contra\">ContraseÃ±a:</label>");
			out.println ("<input type=\"password\" name=\"pass\"><br>");
			out.println ("<p style=\"color:blue\";>Pedido completado con exito<p>");
			out.println ("<input type=\"submit\" value=\"enviar\">");
			out.println ("</form>");
			out.println ("</div>");
			out.println ("</body>");
			out.println ("</html>");
	
	}
		
	}
	
	public void doPost(HttpServletRequest request,
			   HttpServletResponse response)
			   throws ServletException, IOException {
		doGet(request, response);
}
	
}
