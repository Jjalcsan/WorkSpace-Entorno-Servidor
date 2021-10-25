<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>HR Online</title>
<link rel="stylesheet" href="CSS/cssGeneral.css">
</head>
<body>
<div id="div-con-todo">
    <div id="header">
        <div id="div-titulo">
            <p id="p-titulo">HR Online</p>
            <p id="p-subtitulo">La página de registro online de nuevas vivienda</p>
        </div>
        <div id="div-menu">
            <p id="p-opciones"><a href="index.jsp">Inicio</a>&nbsp;&nbsp;<a href="registroForm.jsp">Registre una nueva vivienda</a>&nbsp;&nbsp;<a href="viviendasActuales.jsp">Observe las viviendas actuales</a></p>
        </div>
    </div>
    <div id="div-contenido">
    	<h1><%
    	Integer contador = (Integer)application.getAttribute("contador");
    	if (contador == null || contador == 0){
    		out.println("Bienvenido a HR Online");
    		contador = 1;
    	} else {
    		out.println("Bienvenido de nuevo a HR Online");
    		contador += 1;
    	}
    	application.setAttribute("contador", contador);%></h1>
        <h1>¿Por qué es conveniente inscribir una vivienda en el Registro de la Propiedad?</h1>
        <p>Cuando se realiza la compra de una vivienda hay que hacer numerosos trámites. Uno de ellos, una vez que se ha completado la adquisición del inmueble, es inscribirlo en el Registro de la Propiedad. Esta institución pública es la encargada de crear titularidades sobre bienes inmuebles para favorecer la seguridad jurídica de los mismos.</p>
        <p>Cuando se realiza la compra de una vivienda hay que hacer numerosos trámites. Uno de ellos, una vez que se ha completado la adquisición del inmueble, es inscribirlo en el Registro de la Propiedad. Esta institución pública es la encargada de crear titularidades sobre bienes inmuebles para favorecer la seguridad jurídica de los mismos.</p>
    </div>
    <div id="div-footer">
        <div id="div-enlaces">
            <table aria-describedby="tabla">
                <td class="td-footer">
                    <h2>Sobre HR Online</h2>
                    <p><a href="underConstruction.jsp">¿Quienes somos?</a></p>
                    <p><a href="underConstruction.jsp">Mapa web</a></p>
                    <p><a href="underConstruction.jsp">Sala de prensa</a></p>
                    <p><a href="underConstruction.jsp">Trabaja con nosotros</a></p>
                    <p><a href="underConstruction.jsp">FAQ</a></p>
                </td>
                <td class="td-footer">
                    <h2>Encuentra en HR Online</h2>
                    <p><a href="underConstruction.jsp">Viviendas de segunda mano</a></p>
                    <p><a href="underConstruction.jsp">Viviendas de obra nueva</a></p>
                    <p><a href="underConstruction.jsp">Alquiler de precios</a></p>
                    <p><a href="underConstruction.jsp">Índice de precios</a></p>
                    <p><a href="underConstruction.jsp">Catálogo de productos</a></p>
                </td>
                <td class="td-footer">
                    <h2>Para profesionales</h2>
                    <p><a href="underConstruction.jsp">Anúnciate</a></p>
                    <p><a href="underConstruction.jsp">Contacta con HR Online</a></p>
                    <p><a href="underConstruction.jsp">HR Online Academy</a></p>
                    <p><a href="underConstruction.jsp">Blog para profesionales</a></p>
                    <p><a href="underConstruction.jsp">Entra en tu cuenta</a></p>
                </td>
            </table>
        </div>
        <div id="div-copyright">
            <p>©2021 Jacaranda Spain SL</p>
            <%! private int accesosActuales = 0;%>
            <p> Ya has visitado mi página <%= ++accesosActuales %> veces </p>
        </div>
    </div>   
</div>
</body>
</html>