
<%@page import="dwes.registrados" %>
<%@page import="dwes.usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ES">
<head>

	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>

<%
			//Esta porcion de codigo java se ejecutara una vez se pulse el boton
            if (request.getParameter("enviar") != null) 
            {
                //Creo dos strings con los datos del input
                String usuario = request.getParameter("usuario");
                String contra = request.getParameter("contrasenia");
                
                
                //Compruebo si actualmente hay alguna sesion y hago un bucle que comprobara si los datos del input se corresponden
                //a algun usuario y contraseña almacenados en la clase
                registrados listaUsuarios = new registrados();
                HttpSession sesion = request.getSession();
                for(usuario u : listaUsuarios.getListaUsuarios()){
                	
                	if (u.getNombre().equals(usuario) && u.getContrasenia().equals(contra)){
                		
                		//Si lo encuentra establece los datos del login de la sesion a los introducidos y nos redirige al catalogo
                		sesion.setAttribute("usuario", usuario);
                		sesion.setAttribute("contra", contra);
                		response.sendRedirect("catalogo.jsp");
                		
                	} else {
                		//En caso contrario se nos mostrara una alerta indicando que el usuario o la contraseña no existe
                		out.println("<script>alert('Usuario o contraseña incorrecta');</script>");
                		
                	}}}%>
                	
	<div id="div-principal">
	
		<jsp:include page="header.jsp"></jsp:include>
	
			<div id="div-contenido">
				<form method="POST" action="index.jsp">
					<p class="input" id="nombre">Introduce tu nombre de usuario*</p>
					<input id="usuario" name="usuario">
					<p class="input">Introduce tu contraseña*</p>
					<input id="contra" type="password" name="contrasenia"><br>
					<button type="submit" id="boton" name="enviar">Iniciar sesion</button>
				</form>
			</div>
	
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>