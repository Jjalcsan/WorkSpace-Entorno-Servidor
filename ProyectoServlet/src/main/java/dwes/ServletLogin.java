package dwes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletLogin")
public class ServletLogin extends HttpServlet{

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
					  throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("name");
		String contra = request.getParameter("pass");
		
		if(!nombre.equals("admin") || !contra.equals("admin")) {
			
			out.println ("<html>");
		    out.println ("<body>");
		    out.println ("<div>");
		    out.println ("<h2>Iniciar sesión</h2>");
		    out.println ("<form action=\"ProyectoServlet/servletLogin\" method=\"POST\">");
		    out.println ("<label for=\"nombre\">Nombre:</label>");
		    out.println ("<input type=\"text\" name=\"name\" value=\"nombre\"><br>");
		    out.println ("<label for=\"contra\">Contraseña:</label>");
		    out.println ("<input type=\"password\" name=\"pass\" value=\"contra\"><br>");
		    out.println ("<p>Nombre o contraseña incorrectos<p>");
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
