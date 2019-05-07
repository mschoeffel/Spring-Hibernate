# Spring-Hibernate

---

## Spring Boot
Here I'll show an example how to code a simple Spring Boot Application.
Spring Boot makes it very easy to create a full spring project with all needed dependencies. To set up a Spring Boot Project just go to the website www.start.spring.io. There you can configure all your needed packages. Spring Boot also comes with a built in Web Servery so you don't have to take care of any problems with the web configuration. You can simply run the Application class and Spring Boot will handle all the needed stuff like booting up a Webserver building the project etc etc. 
For every topic you'll find a directory that contains all the needed files like the java classes, the properties and the pom file.

#### 67.
`FirstSetup` directory:\
Spring Boot uses the directory structure of Maven.\
So in the `main/java` directory all your java classes have to be created.\
The `main/resources` directory contains all resources of your project like static content like JS files or CSS files or property files.\
The last important directory is the `test` directory inside of this directory all the JUnit test classes should be stored. 

You may wonder what these mvnw... files are for: These files are Maven Wrapper files and can be used to run a maven project without the need of maven installed on the local machine. It will check if a valid maven version is installed and if not it will automatically download and install one and run it.\
mvnw.cmd is for Windows machines.\
mvn ist for Linux/ Mac machines.\
If you have Maven already installed on your PC you can simply ignore or delete these files.

The `application.properties` file is the auto properties file of the Spring Boot application. There you can set up properties either for the application itself like changing the webserver port or you can simply define custom properties and read them with injection like `@Value("${my.testMsg}")`. An example is in the directory.

#### 68.

A great extension are the spring boot dev tools. You can simply include these in your project with the following maven dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

This simple extension allows you to be more productive when programming spring boot applications, because for example there is no need anymore to recompile your whole application everytime you change the code. The devtool extension will automatically compile and restart the application whenever you make changes on the code.

#### 69.

If you want to monitor the health, performance or memory of your application you can simply make use of the spring boot actuator dependency. This dependency allows you to keep track of all the mentioned stats while running your app. Simply add the following dependency to your ``pom.xml``:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
``` 

Possible information:
These are simple REST endpoints automatically created by the actuator dependency. So you can just call your project URL add ``/actuator`` and one of the following endpoints to get the information like ``localhost:8080/actuator/health``.

Name | Description
---|---
/health | Health information about your application
/info | Information about the project
/beans | List of beans
/mappings | List of all @RequestMapping paths
And many more...

By default the info endpoint is empty. But you can customize every endpoint like you wish by editing the ``application.properties`` file.\
For example:
```properties
info.app.name=Your Cool App Name
info.app.description=This is the description
info.app.version=1.0
```
If you now call the ``/info`` endpoint again you'll get all these information.

**Care:**\
By default only ``/health`` and ``/info`` are exposed over HTTP. To expose the other endpoints as well add the following to your ``application.properties``  file:
 ```properties
# Use Wildcard "*" to expose all endpoints
# Can also expose individual endpoints with a comma-delimited list
management.endpoints.web.exposure.include=*
```

Security is described later because such sensitive information about a application shouldn't be that open. 