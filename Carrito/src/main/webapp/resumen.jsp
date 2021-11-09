<%@page errorPage="paginaError.jsp" %>
<%@page import="dwes.registrados" %>
<%@page import="dwes.catalogo" %>
<%@page import="dwes.producto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//Esta porcion de codigo comprueba que estemos actualmente en una sesion, si los datos del usuario son nulos nos mandara a la pagina de error
	//que nos indicara que necesitamos logearnos para navegar
	HttpSession s = request.getSession();
	if(s.getAttribute("usuario")==null){
		throw new RuntimeException("Debes estar logeado para acceder a esa parte");
}%>    
    
<!DOCTYPE html>
<html lang="ES">
<head>

	<meta charset="UTF-8">
	<title>Resumen de tu compra</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>
	<div id="div-principal">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div id="div-contenido">
			<div id="div-objetos">
			<h1>Resumen de tu compra</h1>
			<div><div>Unidades</div><div>Total</div></div>
			<%
			//Aqui se comprueban que los datos del catalogo no sean nulos y los imprime por pantalla
			//No deberia ser necesario ya que en el input el valor por defecto es 0 y no llegara a ser nulo
			if(s.getAttribute("cantidadHuevos")!=null){
				out.println("<div><p>Huevos: "+s.getAttribute("cantidadHuevos")+"uds</p></div>");
			}
			
			if(s.getAttribute("cantidadLeche")!=null){
				out.println("<div><p>Leche: "+s.getAttribute("cantidadLeche")+"uds</p></div>");
			}
			
			if(s.getAttribute("cantidadCarne")!=null){
				out.println("<div><p>Carne: "+s.getAttribute("cantidadCarne")+"uds</p></div>");
			}
			
			if(s.getAttribute("cantidadPescado")!=null){
				out.println("<div><p>Pescado: "+s.getAttribute("cantidadPescado")+"uds</p></div>");
			}
			
			if(s.getAttribute("cantidadPan")!=null){
				out.println("<div><p>Pan: "+s.getAttribute("cantidadPan")+"uds</p></div>");
			}
			%>
			</div>
			<div id="div-envio">
			
				<h2>Selecciona un metodo de envio</h2>
				<form method="POST" action="resumen.jsp">
				  	<p><input type="radio" id="normal" name="normal" value="2.0">
 					<label for="normal">ENVIO NORMAL: 2€</label><br>
  					<input type="radio" id="express" name="normal" value="6.0">
  					<label for="express">ENVIO EXPRESS: 6€</label><br></p>
  					<p><button name="confirmar">Confirmar</button><a href="catalogo.jsp"><button>Volver</button></a></p>
  				</form>
				
			</div>
			
		</div>
		
		
		<%
		//Al igual que en la pagina del catalogo esta porcion de codigo deberia recoger la opcion de envio del pedido
		//Pero no se tratar los input radio para que recoja el valor
		if(request.getParameter("confirmar")!=null){
			double envio = Double.parseDouble(request.getParameter("normal"));
			response.sendRedirect("factura.jsp");
		}
		
		%>
		
		
	    <jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>

