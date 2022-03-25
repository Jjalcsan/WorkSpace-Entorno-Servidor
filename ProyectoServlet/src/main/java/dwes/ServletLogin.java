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
		    out.println ("<form action=\"/ProyectoServlet/servletLogin\" method=\"POST\">");
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
			
		} else {
			
			out.println ("<html>");
			out.println ("<body>");
			out.println ("<h1>E-Market</h1>");
			out.println ("<h2>Supermercados de confianza</h2>");
			out.println ("<hr>");
			out.println ("<div>");
			out.println ("<h2>Nuestro catalogo</h2>");
			out.println ("<form action=\"/ProyectoServlet/servletMain\" method=\"post\">");
			out.println ("<table>");
			out.println ("<tr>");
			out.println ("<th>Producto</th>");
			out.println ("<th>Cantidad</th>");
			out.println ("<th>Euros/Unidad</th>");
			out.println ("</tr>");
			out.println ("<tr>");
			out.println ("<td>Leche</td>");
			out.println ("<td><input type=\"number\" min=\"0\" name=\"leche\" value=\"0\"></td>");
			out.println ("<td>1.5</td>");
			out.println ("</tr>");
			out.println ("<tr>");
			out.println ("<td>Carne</td>");
			out.println ("<td><input type=\"number\" min=\"0\" name=\"carne\" value=\"0\"></td>");
			out.println ("<td>3.0</td>");
			out.println ("</tr>");
			out.println ("<tr>");
			out.println ("<td>Pescado</td>");
			out.println ("<td><input type=\"number\" min=\"0\" name=\"pescado\" value=\"0\"></td>");
			out.println ("<td>4.0</td>");
			out.println ("</tr>");
			out.println ("<tr>");
			out.println ("<td>Pasta</td>");
			out.println ("<td><input type=\"number\" min=\"0\" name=\"pasta\" value=\"0\"></td>");
			out.println ("<td>1.0</td>");
			out.println ("</tr>");
			out.println ("</table>");
			out.println ("<input type=\"submit\">");
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
