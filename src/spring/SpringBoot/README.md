# Spring-Hibernate

---

## Spring Boot
Here I'll show an example how to code a simple Spring Boot Application.
Spring Boot makes it very easy to create a full spring project with all needed dependencies. To set up a Spring Boot Project just go to the website www.start.spring.io. There you can configure all your needed packages. Spring Boot also comes with a built in Web Servery so you don't have to take care of any problems with the web configuration. You can simply run the Application class and Spring Boot will handle all the needed stuff like booting up a Webserver building the project etc etc. 
For every topic you'll find a directory that contains all the needed files like the java classes, the properties and the pom file.

#### 67.
Spring Boot uses the directory structure of Maven.\
So in the `main/java` directory all your java classes have to be created.\
The `main/resources` directory contains all resources of your project like static content like JS files or CSS files or property files.\
The last important directory is the `test` directory inside of this directory all the JUnit test classes should be stored. 

You may wonder what these mvnw... files are for: These files are Maven Wrapper files and can be used to run a maven project without the need of maven installed on the local machine. It will check if a valid maven version is installed and if not it will automatically download and install one and run it.\
mvnw.cmd is for Windows machines.\
mvn ist for Linux/ Mac machines.