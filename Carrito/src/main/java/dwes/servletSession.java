package dwes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("servletSession")
public class servletSession extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("usuario");
		String contra = request.getParameter("contraseña");
		
		usuarios listaUsuarios = new usuarios();
		catalogo listaProductos = new catalogo();
		
		int intentos = 5;
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<div id=\"div-principal\">");
		out.println("<jsp:include page=\"header.jsp\"></jsp:include>");
		
		if (listaUsuarios.getUsuarios().containsKey(nombre) && listaUsuarios.getUsuarios().containsValue(contra)) {
			out.println("   <div id=\"div-contenido\">\n"
					+ "                <table>\n");
			
			for(Map.Entry<String, Double> entry : listaProductos.getCatalogoProductos().entrySet()) {
				out.println("<tr>\n"
						+ "                        <td>"+entry.getKey()+"</td>\n"
						+ "                        <td>"+entry.getValue()+"€</td>\n"
						+ "                        <td><button>-</button>0<button>+</button></td>\n"
						+ "                    </tr>");
			}		
		} else {
			intentos--;
			if (intentos < 0) {
				out.println("			<div id=\"div-contenido\">\n"
						+ "				<form action=\"dwes.servletSession\" method=\"POST\">\n"
						+ "					<p class=\"input\" id=\"nombre\">Introduce tu nombre de usuario*</p>\n"
						+ "					<input id=\"usuario\" name=\"usuario\">\n"
						+ "					<p class=\"input\">Introduce tu contraseña*</p>\n"
						+ "					<input id=\"contra\" type=\"password\" name=\"contraseña\"><br>\n"
						+ "					<button type=\"submit\" id=\"boton\">Iniciar sesion</button>\n"
						+ "                 <p>Te quedan "+intentos+" intentos antes del bloqueo"
						+ "				</form>\n"
						+ "			</div>");
			}

		}
		
		out.println("<jsp:include page=\"footer.jsp\"></jsp:include>");
		out.println("</div>");
		out.println("</body>");
		out.println("<html>");
		
	}
	
	//http://www.edu4java.com/es/servlet/servlet3.html buena ayuda
	//https://www.galisteocantero.com/sesiones-en-servlets-y-jsp-ejemplo-login-logout/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
}
