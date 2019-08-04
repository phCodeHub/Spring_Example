<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name - <form:input path="firstName"/>
	<br><br>
	Last Name  - <form:input path="lastName"/>
	<br><br>
	Country :
	<form:select path="country">
		<form:options items="${student.countryOp}"/>
		<%-- <form:option value="USA" label="USA"></form:option>
		<form:option value="France" label="France"></form:option>
		<form:option value="Germany" label="Germany"></form:option>
		<form:option value="India" label="India"></form:option> --%>
	
	</form:select>
	
	<br><br>
	Fav Language : 
	Java<form:radiobutton path="favLanguage" value="Java"/>
	C++<form:radiobutton path="favLanguage" value="C++"/>
	Ruby<form:radiobutton path="favLanguage" value="Ruby"/>
	Python<form:radiobutton path="favLanguage" value="Python"/>
	
	<br><br>
	Operating System:
	
	Windows <form:checkbox path="operatingSys" value="windows"/>
	Linux <form:checkbox path="operatingSys" value="linux"/>
	iOS <form:checkbox path="operatingSys" value="ios"/>
	
	<br><br>
	
	<input type="submit" value="Submit"/>  
	
	</form:form>
	
</body>
</html>