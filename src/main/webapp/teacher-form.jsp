<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher</title>
</head>
<body>

	<%@include file="home.jsp"%>
	<div>
		<form action="addTeacher" method="post">

			Enter Teacher Name <input type="text" name="name"> Enter
			email address <input type="email" name="email"> Enter subject
			<input type="text" name="subject"> <input type="submit"
				value="Save">
		</form>
	</div>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<a href="listTeachers">List of Teachers</a>

				</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Subject</th>

			</tr>
			<c:forEach var="teacher" items="${listTeachers}">
				<tr>
					<td><c:out value="${teacher.id}" /></td>
					<td><c:out value="${teacher.teacherName}" /></td>
					<td><c:out value="${teacher.teacherEmail}" /></td>
					<td><c:out value="${teacher.getSubject().getSubjectName()}" /></td>



					<td><a href="deleteTeacher?id=<c:out value='${teacher.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>