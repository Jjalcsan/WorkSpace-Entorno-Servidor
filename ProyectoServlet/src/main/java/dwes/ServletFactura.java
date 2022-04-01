package dwes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletFactura")
public class ServletFactura extends HttpServlet{

	public void doGet(HttpServletRequest request,
	  		  	 	  HttpServletResponse response)
	  		  	 	  throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String unidades = request.getParameter("unidades");
		String total = request.getParameter("total");
		String envio = request.getParameter("envio");
		String nombre = request.getParameter("nombre");
		
		HttpSession sesion = request.getSession();
		
		if(sesion.getAttribute("nombre")==null) {
			
			out.println ("<html>");
		    out.println ("<body>");
		    out.println ("<div>");
		    out.println ("<h2>Iniciar sesión</h2>");
		    out.println ("<form action=\"/ProyectoServlet/servletLogin\" method=\"POST\">");
		    out.println ("<label for=\"nombre\">Nombre:</label>");
		    out.println ("<input type=\"text\" name=\"name\"><br>");
		    out.println ("<label for=\"contra\">Contraseña:</label>");
		    out.println ("<input type=\"password\" name=\"pass\"><br>");
		    out.println ("<p style=\"color:#FF0000\";>Debes iniciar sesión para entrar<p>");
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
			out.println ("<form action=\"/ProyectoServlet/servletPedidoCompletado\" method='post'>");
			out.println ("<h3>Factura del pedido</h3>");
			out.println ("<p>Usuario: "+nombre+"</p>");
			out.println ("<p>Total de productos: "+unidades+" unidades</p>");
			out.println ("<p>Método de envío: "+envio+"</p>");
			if(envio.equals("Normal")) {
				double totalDouble = Double.parseDouble(total);
				double totalConEnvio = totalDouble+2.0;
				out.println("<p>Precio del pedido: "+totalConEnvio+"</p>");
			} else {
				double totalDouble = Double.parseDouble(total);
				double totalConEnvio = totalDouble+5.0;
				out.println("<p>Precio del pedido: "+totalConEnvio+"</p>");
			}
			out.println ("<br><input type='submit' name='enviar' value='Completar pedido'>");
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
