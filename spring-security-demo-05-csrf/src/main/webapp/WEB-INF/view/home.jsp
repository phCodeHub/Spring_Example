<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pulkit Security</title>
</head>
<body>
Welcome to Security
<p>User : <security:authentication property="principal.username"/>
<br><br>
Roles : <security:authentication property="principal.authorities"/>
</p>
<hr>
<p>
	<security:authorize access="hasRole('Manager')">
	<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting (Only for Manager)</a>
	
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/systems">IT Meeting (Only for Admin)</a>
	</security:authorize>	
</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">

	<input type="submit" value = "Logout"/>

</form:form>





</body>
</html>