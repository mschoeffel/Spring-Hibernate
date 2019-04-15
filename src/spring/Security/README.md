# Spring-Hibernate

---

## Spring Security

Here I'll show an example how to code Spring Security Applications.

Just open "[ServerURL]/security/"

You find the Frontend jsp files in the web/WEB-INF/view/security folder.

If you run both the MVC and Security on the same Project you maybe have to change some artifacts to get is working.

This time we also don't use XML for our Config. Instead we only use annotations and classes.

----
So we set up our DemoContoller as contoller and our DemoAppConfig this time holds all of our web.xml config as annotations.
The MySpringMvcDispatchServletInitializer keeps the spring-mvc-demo-sevlet.xml configs.


Server: Apache Tomcat.
