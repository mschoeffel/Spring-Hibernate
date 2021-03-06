# Spring-Hibernate

---

## Spring REST
Here I'll show an example how to code a Spring REST Application.

#### 56. / 57.
First there are some basics to convert a Java object into a json and vice versa. First you have to set up a new project and copy the classes and the necessary folder from this directory. I used Maven so therefore you need the following Maven pom.xml dependency to get the code working for you (also take care to mark the resources directory as resources):
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

Jackson is a quite popular project for creating REST applications and serializing and deserializing objects.

The class ConvertPojoJson shows how easy you can convert a POJO to a JSON and the other way round. When creating the JSON out of a POJO you have to care that the JSON file may be created in the target or out directory depending on your compiler.

#### 58.

To don't get an exception if the JSON changes and get a new property you can simply add the annotation `@JsonIgnoreProperties(ignoreUnknown = true)` to the POJO class and so unknown properties, properties that exist in the JSON file but not in the POJO, will be ignored and no exception will be thrown.

#### 59.

To set up a simple REST API (see `SimpleRestSetup` Folder ) you have to create a Spring web `@RestController` with RequestMappings and GetMappings and a standard Spring `@Configuration`. There you tell Spring where to scan for components. And set up a servlet initializer to get the rest servlet running. To run the code pretty simple use the pom.xml from below and create a Maven project. Then copy the Directory from here to your src directory of your Maven project. Take care to set up the directories correctly and maybe fix the src root to scan for the components in the DemoAppConfig class. To run the servlet then simply use the maven command `clean install jetty:run`. When the server started you can access the REST API with the URL `localhost:8080/test/hello`.

If you want to get a page displayed when you call the blank URL `localhost:8080` you can simply create a folder called `webapp` in the src directory and put there an index.jsp file. Apache will automatically show this page as startpage if you enter the URL; so you dont get a 404 error displayed if you call the blank URL.

#### 60.

In the `SimplePojoJsonRestSetup` directory is a simple setup for a REST service, that returns a Json string automatically generated from Pojo via Jenkins. Spring REST and Jenkins will do this automatically when you want to return a Object as REST Service. To get it working just use the pom.xml from below to build a Maven project and copy the folder. Maybe you have to mark some directories and change the `DemoAppConfig` component scan package and then just call `localhost:8080/api/students` and you will get a Json string containing all three student objects.

#### 61.

If you want to get a specific student see eht folder `PathVariableRest` there you can add to the URL `localhost:8080/api/student/` an ID at the end and the REST controller will read this PathVariable and bind it as parameter to the controller method so there you can work with it and return a specific student. Care the variable name given in the `@GetMapping` annotation needs to be the same as the parameter name at the `PathVariable` annotation by default. 

#### 62.

The directory `FancyRestAll` just contains everything from above just a little bit fancier and in a way more cleaner coding style.

#### 63.

If we enter an invalid Id in the examples above we get a 404 error Html page. This page can display critical information about our REST system.\
So we want to create a custom error handling to send back a JSON, that contains error information, when trying to access a invalid Id. Therefore we use the annotation `@ExceptionHandler` to define a method that gets called when an exception, defined in the parameter, is thrown. This method creates a response object `StudentErrorResponse` that gets sent back to the client. So to achieve custom exception handling we just needed to create a custom exception object, response object and define an custom exception handler. The response object will again automatically converted to a JSON string when returned to the HTTP request.\
The solution is given in the `CustomException` directory.  

#### 64.

If you want to create an exception handler that catches all exception you can simply modify the exception handler from the example above and use the class `Exception` as parameter of the exception handler method instead of the specific `StudentNotFound`.\
You can also create both and when a specific exception is thrown the most specific handler will catch this exception and respond to it. (A "catch all" exception handler is also given in the directory `CustomException`)\
One thing you have to keep in mind: Change the HTTP statuscode to something more general, like BAD_REQUEST.

#### 65.

If you want to create a global exception handler, which is better in most cases, cou simply make use of AOP directory: `GlobalException` (see later topics). There you can create a class `StudentExceptionHandler` and give it the annotation `@ControllerAdvice`. This annotation will make the class known for all the controllers and all controllers can make use of this class and the methods defined in it.?
So this way we created a globally known exception handler class that will handle all the exceptions thrown by any REST controller of the project.

#### 66.

If you wand to make your REST API secure you can simply make use of the spring security. See `AuthorisationREST` directory. Just add the the `DemoSecurityConfig` class and the spring security maven dependency. There you can define, the same way as described in the `Spring Security` section, what user got what role and what permissions to access different APIs. 

pom.xml:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.myRest</groupId>
	<artifactId>spring-rest-demo</artifactId>
	<version>1.0</version>
	<packaging>war</packaging>

	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>

	<dependencies>

		<!-- Add Spring MVC and REST support -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>5.1.6.RELEASE</version>
		</dependency>
		
		<!-- Add Jackson for JSON converters -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.5</version>
		</dependency>

		<!-- Add Servlet support for 
			 Spring's AbstractAnnotationConfigDispatcherServletInitializer -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		</dependency>

		<!-- Add support for JSP ... get rid of Eclipse error -->				 
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.3.1</version>
		</dependency>
				 
	</dependencies>

	<!-- Support for Maven WAR Plugin -->

	<build>
		<finalName>spring-rest-demo</finalName>

		<pluginManagement>
			<plugins>
				<plugin>
					<!-- Add Maven coordinates (GAV) for: maven-war-plugin -->
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-war-plugin</artifactId>
					<version>3.2.0</version>
				</plugin>
				<plugin>
					<groupId>org.eclipse.jetty</groupId>
					<artifactId>jetty-maven-plugin</artifactId>
					<version>9.4.16.v20190411</version>
					<configuration>
						<scanIntervalSeconds>10</scanIntervalSeconds>
					</configuration>
				</plugin>

				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-war-plugin</artifactId>
					<version>3.2.0</version>
				</plugin>
			</plugins>
		</pluginManagement>
	</build>
</project>
```