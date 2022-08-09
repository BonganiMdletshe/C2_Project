<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.util.*, javax.servlet.*, javax.servlet.jsp.*, javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes Form</title>
</head>
<body>

	<%@include file="home.jsp"%>

	<%

if( session == null){
	RequestDispatcher reqDispatcher;
	reqDispatcher = request.getRequestDispatcher("index.html");
	reqDispatcher.include(request, response);
	out.println("<h1> Session Expired </h1>");
}

%>

	<div>
		<form action="ClassesController" method="post">

			Enter subject <input type="text" name="subject"> <input
				type="submit" value="Show Report">
		</form>
	</div>






</body>
</html>