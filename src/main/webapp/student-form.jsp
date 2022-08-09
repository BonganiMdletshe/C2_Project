<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Student</title>
</head>
<body>
	<%@include file="home.jsp"%>
	<div>
		<form action="addStudent" method="post">

			Enter name <input type="text" name="name"> Enter email
			address <input type="email" name="email"> Enter subject <input
				type="text" name="subject"> <input type="submit"
				value="Save" name="saveStudent">
		</form>
	</div>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<a href="listStudents">List of Students</a>

				</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Subject</th>

			</tr>
			<c:forEach var="student" items="${listStudents}">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.studentName}" /></td>
					<td><c:out value="${student.studentEmail}" /></td>
					<td><c:out value="${student.getSubject().getSubjectName()}" /></td>



					<td><a href="deleteStudent?id=<c:out value='${student.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>