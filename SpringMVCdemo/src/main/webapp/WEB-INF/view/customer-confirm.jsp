<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Customer is confirmed ${customer.firstName} ${customer.lastName} Free Passes -- ${customer.freePasses}
Postal Code - ${customer.postalCode }
Course Code - ${customer.courseCode }
</body>
</html>