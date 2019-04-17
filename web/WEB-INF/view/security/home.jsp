<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	
	Welcome to the company home page!

	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>

</body>

</html>