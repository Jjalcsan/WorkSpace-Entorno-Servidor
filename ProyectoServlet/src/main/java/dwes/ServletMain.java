package dwes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletMain")
public class ServletMain extends HttpServlet{

	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
			  		  throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int leche = Integer.parseInt(request.getParameter("leche"));
		int carne = Integer.parseInt(request.getParameter("carne"));
		int pescado = Integer.parseInt(request.getParameter("pescado"));
		int pasta = Integer.parseInt(request.getParameter("pasta"));
		
		out.println ("<html>");
		out.println ("<body>");
		out.println ("<h1>E-Market</h1>");
		out.println ("<h2>Supermercados de confianza</h2>");
		out.println ("<hr>");
		out.println ("<div>");
		out.println ("<h3>Tu resumen</h3>");
		out.println ("<form action=\"/ProyectoServlet/servletFactura\" method='post'>");
		out.println ("<table>");
		out.println ("<tr>");
		out.println ("<th>Producto</th>");
		out.println ("<th>Unidades</th>");
		out.println ("<th>Total</th>");
		out.println ("</tr>");
		
		if(leche!=0) {
			out.println ("<tr>");
			out.println ("<td>Leche</td>");
			out.println ("<td><input type=\"text\" readonly name=\"leche\" value="+leche+"></td>");
			out.println ("<td><input type=\"text\" readonly name=\"lecheTotal\" value="+leche*1.5+"></td>");
			out.println ("</tr>");
		}
		
		if(carne!=0) {
			out.println ("<tr>");
			out.println ("<td>Carne</td>");
			out.println ("<td><input type=\"text\" readonly name=\"carne\" value="+carne+"></td>");
			out.println ("<td><input type=\"text\" readonly name=\"carneTotal\" value="+carne*3.0+"></td>");
			out.println ("</tr>");
		}
		
		if(pescado!=0) {
			out.println ("<tr>");
			out.println ("<td>Pescado</td>");
			out.println ("<td><input type=\"text\" readonly name=\"pescado\" value="+pescado+"></td>");
			out.println ("<td><input type=\"text\" readonly name=\"pescadoTotal\" value="+pescado*4.0+"></td>");
			out.println ("</tr>");
		}
		
		if(pasta!=0) {
			out.println ("<tr>");
			out.println ("<td>Pasta</td>");
			out.println ("<td><input type=\"text\" readonly name=\"pasta\" value="+pasta+"></td>");
			out.println ("<td><input type=\"text\" readonly name=\"pastaTotal\" value="+pasta*1.0+"></td>");
			out.println ("</tr>");
		}

		out.println ("</table");
		out.println ("<hr>");
		out.println ("<h3>Elige tu metodo de envio</h3>");
		out.println ("<input type=\"radio\" name=\"envio\" value=\"Normal\" checked>");
		out.println ("<label>Envio normal: 2 euros adicionales</label><br>");
		out.println ("<input type=\"radio\" name=\"envio\" value=\"Express\">");
		out.println ("<label>Envio express: 5 euros adicionales</label>");
		out.println ("<br><input type='submit' name='enviar'>");
		out.println ("</form>");
		out.println ("</body>");
		out.println ("</html>");
		
	}
	
	public void doPost(HttpServletRequest request,
	  		  		   HttpServletResponse response)
	  		  		   throws ServletException, IOException {
		doGet(request, response);
	}
}
