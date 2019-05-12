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

#### 70.

To secure your spring boot actuator pages you have to add the spring security dependency to your pom file:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

After adding the dependency whenever you try to call an actuator endpoint spring will display a login form.
The default login is `user` and the password gets shown when starting the app in the console log. There have to be something like: `Using generated security password: [SOME GUID]` and the GUID is the password.

If you don't want to use the default credentials yo can add the following two lines to your `application.properties`:
```properties
spring.security.user.name=TheUsernameYouWant
spring.security.user.password=ThePasswordYouWant
```

But if you want more advanced login stuff like database user and password you can do this like the normal Spring Security and authorize the `auctuator/**` route.

If you want some pages not to get displayed you can achieve it by adding the following line to your `application.properties`:
```properties
management.endpoints.web.exposure.exclude=CommaSeparatedPages,OtherPage
```

#### 71.

To run the application with the command line you got two options:

First you can run it with the `java -jar` command plus the name of the jar file. Like `java -jar myApp.jar`.\
**Care:** You have to be in the same directory with your command line as the jar is stored otherwise you have to either navigate with the command tool there or add the path to the jar name.

Second you can run it with the Maven command `mvnw spring-boot:run`.\
Be careful Maven has to be installed on the device you want to run the app from. You can simply install Maven using the wrapper executables that came with the spring boot project structure (see point 67.)

With the command `mvnw package` you can create the jar file easily. Like above cae to be in the right directory. This time your project directory.\
The jar file is created in the `target` sub-directory!

#### 72.

To create your own properties you can simply make use of the already existing `application.properties` file.\
Just add your own properties there. To get the value from the property you can use the `@Value` annotation and spring will automatically inject the value of the properties file to your variable.

application.properties:
```properties
my.new.property=SuperValue
```

class:
```java
...
    @Value("${my.new.property}")
    private String myProperty;
...
```

#### 73.

With the `application.properties` file you can configure the Spring Boot server. So for example there are over 1000 properties you can set to configure the application. They are roughly divided in eight groups: Core, Web, Security, Data, Actuator, Integration, DevTools and Testing.\
In the Core are for example properties like logging levels.\
In the Web are for example Port configurations, session timeouts and the context path.\
The Actuator properties we've already seen.\
The Security properties we've also already seen.\
In the Data are for examples properties used to connect to a database or to configure transaction timeouts.\
...
