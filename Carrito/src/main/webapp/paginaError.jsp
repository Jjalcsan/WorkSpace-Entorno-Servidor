<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Error</title>
	<link rel="Stylesheet" href="CSS/cssHeader.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssFooter.css" type="text/css">
	<link rel="Stylesheet" href="CSS/cssIndex.css" type="text/css">
	
</head>
<body>
	<div id="div-principal">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div>
		<h2>Ups...</h2>
		<p>Parece que algo fue mal</p>
		<p><% exception.printStackTrace(response.getWriter()); %></p>
		</div>
		
	    <jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>