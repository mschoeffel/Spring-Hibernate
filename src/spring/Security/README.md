# Spring-Hibernate

---

## Spring Security

Here I'll show an example how to code a Spring Security Application.

Just open "[ServerURL]/security/"

You find the frontend jsp files in the web/WEB-INF/view/security folder.

If you run both the MVC and Security on the same project you maybe have to change some artifacts to get it working.

This time we also don't use XML for our config. Instead we only use annotations and classes.

If you want to get it properly working use the Maven file below and just copy the Security directory and the frontend directory.\
Then you can run the application with the maven command `clean install jetty:run`. Just call `http://localhost:8080/spring` to open the website.
----
So we set up our DemoController as controller. Our DemoAppConfig this time holds all of our web.xml config as annotations.
The MySpringMvcDispatchServletInitializer keeps the spring-mvc-demo-sevlet.xml configs.
Additional we added the DemoSecurityConfig, the SecurityWebApplicationInitializer and the LoginController for the Spring security setup.

In a first step the username and password is hardcoded in the DemoSecurityConfig but later we will connect the login to a database with hashed passwords etc.
Only if the user is correctly logged in he/she can see the company website.


Server: Apache Tomcat.

Maven pom.xml\
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>spring-security-demo</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>

    <name>spring-security-demo</name>

    <properties>
        <springframework.version>5.0.2.RELEASE</springframework.version>
        <springsecurity.version>5.0.0.RELEASE</springsecurity.version>

        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>

        <!-- Spring MVC support -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${springframework.version}</version>
        </dependency>

        <!-- Spring Security -->
        <!-- spring-security-web and spring-security-config -->

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>${springsecurity.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>${springsecurity.version}</version>
        </dependency>

        <!-- Servlet, JSP and JSTL support -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.1</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

    </dependencies>


    <build>
        <finalName>spring-security-demo</finalName>

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
                        <webApp>
                            <contextPath>/spring</contextPath>
                        </webApp>
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