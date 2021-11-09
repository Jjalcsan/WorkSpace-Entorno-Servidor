<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ES">
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
	<!-- CONTENIDO HTML DE LA CABECERA DE LA PAGINA-->

	<div id="div-cabecera">

		<div id="div-titulo">
			<h3 id="titulo">CARRITO DE LA COMPRA</h3>
			<p id="subtitulo">Time to buy</p>
		</div>

		<!-- ESTE DIV MOSTRARA EL BOTON DE LOGIN EN EL CASO DE QUE NO HAYA UNA SESION ACTIVA
		SI YA SE HA INICIADO SESION EN SU LUGAR MOSTRARA UN MENSAJE DE BIENVENIDA CON EL NOMBRE DEL USUARIO -->

		<div id="div-login">
			<% HttpSession s = request.getSession(false);
			if(s.getAttribute("usuario")==null){
				%>
				<p>Es necesario iniciar sesion para moverse por la página*</p>	
				<p><a href="index.jsp">LOGIN</a></p>
			<% }else{ %>
				<p>Bienvenido <% out.println(s.getAttribute("usuario")); %></p>	
			<% }%>
		</div>

	</div>
	
</body>
</html>