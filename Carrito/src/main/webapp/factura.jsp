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
	<title>Factura</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>
	<div id="div-principal">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div id="div-contenido">
		
		<h1>Factura del pedido actual</h1>
		<!-- Aqui imprimimos por pantalla todos los datos que hemos guardado en la sesion para ver los datos de la factura
		Como se ha comentado en el JSP del resumen el campo de envio saldra null por no saber tratar y recoger dichos datos -->
		<p>Nombre del usuario: <% out.println(s.getAttribute("usuario")); %></p>
		<p>Total a pagar:  <% out.println(s.getAttribute("total")); %>€</p>
		<p>Añadido por IVA: <% out.println(s.getAttribute("iva")); %>€</p>
		<p>Añadido del envio: <% out.println(s.getAttribute("normal")); %>€</p>
		<a href="index.jsp"><button name="finalizar">Confirmar compra</button></a>
		
		</div>
		
	    <jsp:include page="footer.jsp"></jsp:include>
		
	</div>

</body>
</html>