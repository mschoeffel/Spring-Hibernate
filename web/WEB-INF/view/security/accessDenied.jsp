<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>Access Denied</title>
</head>

<body>
	<h2>Access Denied</h2>
	<hr>
	
	You donn't have the necessary Role to access this Page.
	<p>Name: <security:authentication property="principal.username"/></p>
	<p>Role: <security:authentication property="principal.authorities"/></p>

	<hr>

	<p>
		<a href="${pageContext.request.contextPath}/">Back Home</a>
	</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
	<input type="submit" value="Logout">
</form:form>

</body>

</html>