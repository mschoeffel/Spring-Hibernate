<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	
	Welcome to the company home page!

	<p>Name: <security:authentication property="principal.username"/></p>
	<p>Role: <security:authentication property="principal.authorities"/></p>

	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>

</body>

</html>