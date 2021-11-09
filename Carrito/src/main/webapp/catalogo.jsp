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
	<title>Catalogo</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>
	<div id="div-principal">
	
	<jsp:include page="header.jsp"></jsp:include>
	
		<div id="div-productos">
			
			<form method="POST" action="catalogo.jsp">
		
			<%
			
			//Con este bucle se imprime por pantalla los datos almacenados del catalogo de productos
			catalogo listaProductos = new catalogo();
			
			for (producto p : listaProductos.getListaProductos()){
				out.println("<div>\n"
						+ "                        <div>"+p.getNombre()+"</div>\n"
						+ "                        <div>"+p.getPrecio()+"€</div>\n"
						+ "                        <div><p>Cantidad: <input id="+p.getNombre()+" name="+p.getNombre()+" value="+0+">uds</p></div>\n"
						+ "                    </div>");
			}
			
			%>
			<button name="enviar">Terminar compra</button>
			</form>
			
			<%
			//Esta porcion de codigo java se ejecutara una vez se pulse el boton
			if (request.getParameter("enviar") != null) 
            {
				
				catalogo precios = new catalogo();
				//Guardamos las cantidades de los inputs como strings
                String huevos = request.getParameter("Huevos");
                String leche = request.getParameter("Leche");
                String carne = request.getParameter("Carne");
                String pescado = request.getParameter("Pescado");
                String pan = request.getParameter("Pan");
                
                
                //Con todo este codigo calculamos aqui el precio total de cada producto añadido multiplicado por su precio
                //ademas hacemos el calculo del iva del producto y guardamos los dos datos en la sesion para utilizarlos mas tarde
                double nhuevos = Double.parseDouble(request.getParameter("Huevos"));
                double nleche = Double.parseDouble(request.getParameter("Leche"));
                double ncarne = Double.parseDouble(request.getParameter("Carne"));
                double npescado = Double.parseDouble(request.getParameter("Pescado"));
                double npan = Double.parseDouble(request.getParameter("Pan"));
                
                double total = 0;
                
                for (producto p : precios.getListaProductos()){
                	if(p.getNombre().equals("Huevos")){
                		total += nhuevos * p.getPrecio();
                	}
                	if(p.getNombre().equals("Leche")){
                		total += nleche * p.getPrecio();
                	}
                	if(p.getNombre().equals("Carne")){
                		total += ncarne * p.getPrecio();
                	}
                	if(p.getNombre().equals("Pescado")){
                		total += npescado * p.getPrecio();
                	}
                	if(p.getNombre().equals("Pan")){
                		total += npan * p.getPrecio();
                	}
                }
                
                double iva = total*0.10;
                
                s.setAttribute("total", total);
                s.setAttribute("iva", iva);
				//Aqui guardamos en la sesion los datos de los string para mostrarlos en el resumen
                s.setAttribute("cantidadHuevos", huevos);
                s.setAttribute("cantidadLeche", leche);
                s.setAttribute("cantidadCarne", carne);
                s.setAttribute("cantidadPescado", pescado);
                s.setAttribute("cantidadPan", pan);
                //Y finalmente nos lleva al resumen
                response.sendRedirect("resumen.jsp");
                
            }
			%>
			
		</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	</div>
</body>
</html>