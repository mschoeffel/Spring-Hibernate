# Spring-Hibernate

---

## Spring MVC

Here I'll show an example how to code Spring MVC.

### Initial:
Added: HomeController

Added web.xml

Added: spring-mvc-demo-servlet.xml

Added: main-menu.jsp 

---
First I created a web.xml file in the web/WEB-INF directory and a spring-mvc-demo-servlet.xml.
The web.xml defines the dispatcher, refers to the spring-mvc-demo-servlet.xml and defines the url-pattern.
The spring-mvc-demo-servlet.xml defines where to scan for beans and the view resolver with pre- and postfix to create an url.
The HomeController defines the url-pattern and what view to show by default.

### Read Form Data with MVC:
Added: HelloWorldController

Added: helloworld.jsp

Added: helloworld-form.jsp

---
The HelloWorldController controls the two views helloworld and helloworld-form. By calling /showForm it will show the helloworld-Form.jsp and by calling /processForm it will show the helloworld.jsp.
By submitting the form of the helloworld-form.jps the controller will open the helloworld.jsp and send all the GET parameter there.
In the helloworld.jsp you can get the parameter like any other jsp file with "${param.NAME}".
Also in the main-menu.jsp is now a link to the helloworld-form.

### Read Form Data with MVC Advanced
Modified: HelloWorldController (added the two new methods for form2)

Added: helloworld2.jsp

Added: helloworld-form2.jsp

---
This time we added two parameter to the controller method HttpServletRequest with the ServletRequest of the form and Model which contains our model of the MVC pattern and is sent to the view.
This way we can receive the parameter from the HttpServletRequest, manipulate them and add them to the model, which is sent to the view.
In our view we can get Attributes form the model by calling "${ATTRIBUTENAME}".

ADD: Static content like images, css or js can be defined in the spring-mvc-demo-servlet.xml 

```xml
<mvc:resources mapping="/resources/**" location="/resources/"></mvc:resources>
``` 

and then used with the following examples:

```jsp
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"/>
```

### Read Form Data with MVC Advanced with Annotation
Modified: HelloWorldController (added the two new methods for form 3)

Added: helloworld-form3.jsp

---
This time we make use of the "RequestParam" annotation to get a parameter of the submitted form to the controller in this case we just added "@RequestParam("userName") String name" as Parameter to our method and inside of the method we can use the parameter name and it contains the "userName" of the submitted form.


Server: Apache Tomcat.
