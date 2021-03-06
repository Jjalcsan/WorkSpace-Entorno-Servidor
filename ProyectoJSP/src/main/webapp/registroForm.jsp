<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<div id="div-con-todo">
    <div id="header">
        <div id="div-titulo">
            <p id="p-titulo">HR Online</p>
            <p id="p-opciones">La página de registro de nuevas vivienda online</p>
        </div>
        <div id="div-menu">
            <p><a href="index.jsp">Inicio</a>&nbsp;&nbsp;<a href="registroForm.jsp">Registre una nueva vivienda</a>&nbsp;&nbsp;<a href="viviendasActuales.jsp">Observe la ultima vivienda añadida</a></p>
        </div>
    </div>
    <div id="div-contenido">
        <h2>Inscripción de nueva vivienda</h2>
        <!-- Con este formulario enviamos los datos a viviendasActuales para que muestre el resultado -->
        <form action="viviendasActuales.jsp" method="post">
        	<input name="nombre" placeholder="Escribe un nombre para la vivienda"><br>
        	<input name="direccion" placeholder="Dirección de la vivienda"><br>
        	<input name="habitaciones" placeholder="¿Cuántas habitaciones tiene?"><br>
        	<select name="tipoPiso">
            	<option>--Tipo de vivienda--</option>
            	<option>Casa</option>
            	<option>Duplex</option>
            	<option>Estudio</option>
            	<option>Piso normal</option>
        	</select>
        	<button type="submit">Inscribir</button>
        </form>
    </div>
    <div id="div-footer">
        <div id="div-enlaces">
            <table aria-describedby="tabla">
                <td>
                    <h2>Sobre HR Online</h2>
                    <p><a href="underConstruction.jsp">¿Quienes somos?</a></p>
                    <p><a href="underConstruction.jsp">Mapa web</a></p>
                    <p><a href="underConstruction.jsp">Sala de prensa</a></p>
                    <p><a href="underConstruction.jsp">Trabaja con nosotros</a></p>
                    <p><a href="underConstruction.jsp">FAQ</a></p>
                </td>
                <td>
                    <h2>Encuentra en HR Online</h2>
                    <p><a href="underConstruction.jsp">Viviendas de segunda mano</a></p>
                    <p><a href="underConstruction.jsp">Viviendas de obra nueva</a></p>
                    <p><a href="underConstruction.jsp">Alquiler de precios</a></p>
                    <p><a href="underConstruction.jsp">Índice de precios</a></p>
                    <p><a href="underConstruction.jsp">Catálogo de productos</a></p>
                </td>
                <td>
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
        </div>
    </div>   
</div>
</body>
</html>