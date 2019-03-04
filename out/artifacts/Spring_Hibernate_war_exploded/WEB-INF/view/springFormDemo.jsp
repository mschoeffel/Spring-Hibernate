<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 04.03.2019
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringForm</title>
</head>
<body>

<form:form action="processSpringForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br/>
    Last name: <form:input path="lastName"/>
    <br/>
    Gender:
    <form:select path="gender">
        <form:option value="male" label="Male"/>
        <form:option value="female" label="Female"/>
        <form:option value="div" label="Diverse"/>
    </form:select>
    <br/>
    Country:
    <form:select path="country">
        <form:options items="${student.countrySelect}"/>
    </form:select>
    <br/>
    Favorite Language: <br/>
    Java <form:radiobutton path="programming" value="java"/><br/>
    C# <form:radiobutton path="programming" value="csharp"/><br/>
    PHP <form:radiobutton path="programming" value="php"/><br/>
    Python <form:radiobutton path="programming" value="python"/><br/>
    <br/>
    Newsletter: <form:checkbox path="newsletter" value="true"/>
    <br/>

    <input type="submit" value="submit"/>
</form:form>

</body>
</html>
