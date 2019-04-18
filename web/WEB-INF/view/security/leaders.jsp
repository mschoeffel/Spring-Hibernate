<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>lCompany Home Page</title>
</head>

<body>
	<h2>Only for Leaders</h2>
	<hr>

	Welcome to the Leaders!
	<p>Name: <security:authentication property="principal.username"/></p>
	<p>Role: <security:authentication property="principal.authorities"/></p>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
	<input type="submit" value="Logout">
</form:form>

</body>

</html>