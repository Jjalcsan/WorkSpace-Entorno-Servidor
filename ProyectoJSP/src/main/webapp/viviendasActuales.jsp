<%@page import="dwes.Vivienda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>
<div id="div-con-todo">
    <div id="header">
        <div id="div-titulo">
            <p id="p-titulo">HR Online</p>
            <p id="p-opciones">La página de registro online de nuevas viviendas </p>
        </div>
        <div id="div-menu">
            <p><a href="index.jsp">Inicio</a>&nbsp;&nbsp;<a href="registroForm.jsp">Registre una nueva vivienda</a>&nbsp;&nbsp;<a href="viviendasActuales.jsp">Observe la ultima vivienda añadida</a></p>
        </div>
    </div>
    <div id="div-contenido">
    	<h1>Estos son los datos de la ultima vivienda añadida</h1>
    	<!-- En esta tabla sacaremos por pantalla los resultados introducidos en registroForm.jsp para mostrar la ultima vivienda -->
    	<table aria-describedby="tabla">
    		<td>
    		    <jsp:useBean id="nombre" class="dwes.Vivienda"></jsp:useBean>
    			<jsp:setProperty name="nombre" property="nombre" param="nombre"/>
    			<jsp:getProperty property="nombre" name="nombre"/>
    		</td>
    		    <jsp:useBean id="direccion" class="dwes.Vivienda"></jsp:useBean>
    			<jsp:setProperty name="direccion" property="direccion" param="direccion"/>
    			<jsp:getProperty property="direccion" name="direccion"/>
    		</td>
    		<td>
    		    <jsp:useBean id="habitaciones" class="dwes.Vivienda"></jsp:useBean>
    			<jsp:setProperty name="habitaciones" property="habitaciones" param="habitaciones"/>
    			<jsp:getProperty property="habitaciones" name="habitaciones"/>    		
    		</td>
    		<td>
    		    <jsp:useBean id="tipoPiso" class="dwes.Vivienda"></jsp:useBean>
    			<jsp:setProperty name="tipoPiso" property="tipoPiso" param="tipoPiso"/>
    			<jsp:getProperty property="tipoPiso" name="tipoPiso"/>    		
    		</td>
		</table>
    </div>
    <div id="div-footer">
        <div id="div-enlaces">
            <table aria-describedby="tabla2">
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