<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>
	<div id="div-principal">
	
		<jsp:include page="header.jsp"></jsp:include>
	
			<div id="div-contenido">
				<form action="dwes.servletSession" method="POST">
					<p class="input" id="nombre">Introduce tu nombre de usuario*</p>
					<input id="usuario" name="usuario">
					<p class="input">Introduce tu contraseña*</p>
					<input id="contra" type="password" name="contraseña"><br>
					<button type="submit" id="boton">Iniciar sesion</button>
				</form>
			</div>
	
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>