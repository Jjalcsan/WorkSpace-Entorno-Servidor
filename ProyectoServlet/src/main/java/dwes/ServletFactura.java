package dwes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletFactura")
public class ServletFactura extends HttpServlet{

	public void doGet(HttpServletRequest request,
	  		  	 	  HttpServletResponse response)
	  		  	 	  throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int leche = Integer.parseInt(request.getParameter("leche"));
		if(request.getParameter("leche")==null) {
			leche = 0;
		}
		int carne = Integer.parseInt(request.getParameter("carne"));
		if(request.getParameter("carne")!=null) {
			carne = 0;
		}
		int pescado = Integer.parseInt(request.getParameter("pescado"));
		if(request.getParameter("pescado")!=null) {
			pescado = 0;
		}
		int pasta = Integer.parseInt(request.getParameter("pasta"));
		if(request.getParameter("pasta")!=null) {
			pasta = 0;
		}
		int unidades = leche + carne + pescado + pasta;
		
		double lecheTotal = Double.parseDouble(request.getParameter("lecheTotal"));
		if(request.getParameter("lecheTotal")==null) {
			lecheTotal = 0;
		}
		
		double carneTotal = Double.parseDouble(request.getParameter("carneTotal"));
		if(request.getParameter("carneTotal")!=null) {
			carneTotal = 0;
		}
		
		double pescadoTotal = Double.parseDouble(request.getParameter("pescadoTotal"));
		if(request.getParameter("pescadoTotal")!=null) {
			pescadoTotal = 0;
		}
		
		double pastaTotal = Double.parseDouble(request.getParameter("pastaTotal"));
		if(request.getParameter("pastaTotal")!=null) {
			pastaTotal = 0;
		}


		String envio = request.getParameter("envio");
		
		out.println ("<html>");
		out.println ("<body>");
		out.println ("<h1>E-Market</h1>");
		out.println ("<h2>Supermercados de confianza</h2>");
		out.println ("<hr>");
		out.println ("<div>");
		out.println ("<h3>Factura del pedido</h3>");
		out.println ("<p>Usuario: recoger nick de la sesion</p>");
		out.println ("<p>Total de productos: "+unidades+" unidades</p>");
		out.println ("<p>Método de envío: "+envio+"</p>");
		if(envio.equals("Normal")) {
			double total = lecheTotal+carneTotal+pescadoTotal+pastaTotal+2.0;
			out.println("<p>Precio del pedido: "+total+"</p>");
		} else {
			double total = lecheTotal+carneTotal+pescadoTotal+pastaTotal+5.0;
			out.println("<p>Precio del pedido: "+total+"</p>");
		}
		out.println ("<button>Confirmar pedido</button>");
		out.println ("</div>");
		out.println ("</body>");
		out.println ("</html>");
	}
	
	public void doPost(HttpServletRequest request,
	  		   		   HttpServletResponse response)
	  		   		   throws ServletException, IOException {
		doGet(request, response);
	}
	
}
