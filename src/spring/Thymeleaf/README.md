# Spring-Hibernate

---

## Thymeleaf

Thymeleaf is a very powerful front-end template. Like JSP. But the main difference is, Thymeleaf can be used in a web and non-web environment where instead JSP can only be used in a web environment.\
Some non-web environments can be: E-Mail templates, CSV templates or creating a PDF file.

#### 74.

In the `FirstSetup` folder is the first little setup making use of Thymeleaf. It contains everything needed for a first Thymeleaf application.\
A `DemoController` is setup do direct the URL to the right HTML file in the "resources/templates" folder. The `helloworld.html` there uses Thymeleaf to display the information given by the model from the controller.

You can simply add Thymeleaf to your project using the dependency:
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

#### 75.

(See `CSSExample` directory)\
In Thymeleaf you can simply add static CSS to your HTML pages.\
To reference a local CSS file just create a CSS file in the "resources/static" folder. Afterwards link the HTML page to your CSS using Thymeleaf linking: `<link rel="stylesheet" th:href="@{/SubfolderOfStatic/NameOfYourCSS.css}" />`. Now you can make use of the whole CSS file you have created.\
If you want to make use of a remote CSS file you can just link them with the normal HTML `href` tag and URL of your remote CSS.

#### 76.

(See `TableExample` directory)\
To create a datatable you can use the `th:each` attribute. within the attribute value you can set a temporary object, which represents every table row from a list of objects. Inside of the table you now access only the temporary object and call the data of this.\
So you get the following construct to display employees out of a list called data from the model:

```html
<tbody>
    <tr th:each="tempEmp : ${data}">
        <td th:text="${tempEmp.firstName}"></td>
        <td th:text="${tempEmp.lastName}"></td>
        <td th:text="${tempEmp.email}"></td>
    </tr>
</tbody>
```