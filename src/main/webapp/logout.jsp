<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout</title>
</head>
<body>

	<%
	session.invalidate();
	%>

	<h1>Session expired!</h1>
	<form action="index.html">
		<input type="submit" value="Login">
	</form>


</body>
</html>