<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	The Student is confirmed : ${student.firstName} ${student.lastName }
	<br>
	Country : ${student.country }
	
	<br>
	Fav Language : ${student.favLanguage}
	
	<br>
	Operating System
	<ul>
		<c:forEach var="temp" items="${student.operatingSys}">
		<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>