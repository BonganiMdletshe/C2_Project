<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>


	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<a href="list">List of Students</a>

				</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>

			</tr>
			<c:forEach var="student" items="${listStudents}">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.studentName}" /></td>


					<td><a href="delete?id=<c:out value='${student.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>