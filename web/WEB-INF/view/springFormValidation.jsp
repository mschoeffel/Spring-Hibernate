<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 05.03.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FormValidation</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form action="processValidation" modelAttribute="customer">

    First name: <form:input path="firstName" />

    <br><br>

    Last name (*): <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />

    <br><br>

    PostalCode (*): <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error" />

    <br><br>

    Tickets (*): <form:input path="tickets" />
    <form:errors path="tickets" cssClass="error" />

    <br><br>

    Invoice Number (*): <form:input path="invoiceNumber" />
    <form:errors path="invoiceNumber" cssClass="error" />

    <br><br>

    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
