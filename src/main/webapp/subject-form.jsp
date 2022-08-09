<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>
</head>
<body>


<%@include file="home.jsp"%>
	<div>
		<form action="addSubject" method="post">

			Enter Subject Name <input type="text" name="name"> 
			Enter Subject Time <input type="text" name="time">
			 
			<input type="submit" value="Save" name="Add Subject">
		</form>
	</div>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<a href="listSubjects">Subject Details</a>

				</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Time</th>
				
				

			</tr>
			<c:forEach var="subject" items="${listSubjects}">
				<tr>
					<td><c:out value="${subject.id}" /></td>
					<td><c:out value="${subject.subjectName}" /></td>
					<td><c:out value="${subject.subjectTime}" /></td>
					
					<td><a href="deleteSubject?id=<c:out value='${subject.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>