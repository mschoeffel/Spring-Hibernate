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

**Note:** The Spring `<form:form>` tag automatically provides CSRF protection! If you want to use the standard HTML `<form>` take care to add the CSRF protection manually by adding: `<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" \>` to every login form!

To show the UserId and Role you have to add the "Spring Security Tag Library"(see pom.xml). With this library included to the jsp page you can access the UserId and Role with the tags: `<security:authentication property="principal.username"/>` for the User and `<security:authentication property="principal.authorities"/>` for the Role. 

To authorize special roles to special sections of the WebApp you have to use the `.antMatchers("/").hasRole("EMPLOYEE")` method in the SpringSecurityConfig when authorizing a request in the `configure` method. If you want to authorize multiple roles you can use the following method instead an give a list of comma separated roles: `.antMatchers("/system/").hasAnyRole("MANAGER", "ADMIN")`. The parameter of the antMatcher defines the URL-path you want to authorize a `/**` means "also all pages below the given page".

To show a custom access denied page you have to add the method `.exceptionHandling().accessDeniedPage("/accessDenied")` to your SpringSecurityConfig. the parameter given in the `accessDeniedPage` method is the page that get's displayed when no access is granted for a user and their role is not authorized to view a page. Care you have to create a ControllerMapping to route this page!

To display content based on the role just simply use the tag: `<security:authorize access="hasRole('MANAGER')">` the String you give the `hasRole()` method as parameter is the role that gets to see the content between the opening and closing tag of `<security:authorize>`.

To use a database as storage for your user and role credentials aou have to set up two tables: `users` and `authorities` in the `users` table you save the username as primary key, the password in the following scheme `{HASH_ALORITHM}PASSWORD` and a bool enabled. In the `authorities`  table you stare the username of the users table as foreign key and the authority in the scheme `ROLE_YOURROLE`. a example db scrip is at the end of the README.
After setting up the database and inserting the users and roles you have to add a new bean to the DemoAppConfig that returns you the DataSource to the MySql connection. In the DemoSpringConfig you have to change the hardcoded users and roles to a new method `auth.jdbcAuthentication().dataSource(securityDataSource);` where auth is the Autowired new bean created in the DemoAppConfig. 

Server: Apache Tomcat.

Maven pom.xml
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
        
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-taglibs</artifactId>
            <version>${springsecurity.version}</version>
        </dependency>
        
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.13</version>
        </dependency>
        
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.2</version>
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

Database tables:
```mysql
create table users
(
  username varchar(50) not null primary key,
  password char(60)    null,
  enabled  tinyint(1)  null
);

INSERT INTO springhibernate.users (username, password, enabled) VALUES ('john', '{noop}test123', 1);
INSERT INTO springhibernate.users (username, password, enabled) VALUES ('mary', '{noop}test123', 1);
INSERT INTO springhibernate.users (username, password, enabled) VALUES ('susan', '{noop}test123', 1);

create table authorities
(
  username  varchar(50) null,
  authority varchar(50) null,
  constraint authorities_users_username_fk
    foreign key (username) references users (username)
);

INSERT INTO springhibernate.authorities (username, authority) VALUES ('john', 'ROLE_EMPLOYEE');
INSERT INTO springhibernate.authorities (username, authority) VALUES ('mary', 'ROLE_EMPLOYEE');
INSERT INTO springhibernate.authorities (username, authority) VALUES ('mary', 'ROLE_MANAGER');
INSERT INTO springhibernate.authorities (username, authority) VALUES ('susan', 'ROLE_EMPLOYEE');
INSERT INTO springhibernate.authorities (username, authority) VALUES ('susan', 'ROLE_ADMIN');
```
