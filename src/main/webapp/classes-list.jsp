<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class List</title>
</head>
<body>

	<%@include file="home.jsp"%>

	<div align="center">

		<sql:setDataSource user="root" password="mysqlCMB!22"
			url="jdbc:mysql://localhost:3306/hibernatedemo?useSSL=false"
			driver="com.mysql.cj.jdbc.Driver" />

		<sql:query var="resultSet"
			sql="select subjectName, subjectTime, studentName, teacherName
				from subject subj, student st , teacher t
				WHERE subj.id = ${resultId} and st.studentSubject_id = ${resultId} and subj.id = t.subject_id">

		</sql:query>



		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<a>List of Classes</a>

				</h2>
			</caption>
			<tr>
				<th>Class Name</th>
				<th>Time</th>
				<th>Student</th>
				<th>Teacher</th>

			</tr>
			<c:forEach var="row" items="${resultSet.rows}">
				<tr>
					<td><c:out value="${row.subjectName}" /></td>
					<td><c:out value="${row.subjectTime}" /></td>
					<td><c:out value="${row.studentName}" /></td>
					<td><c:out value="${row.teacherName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>