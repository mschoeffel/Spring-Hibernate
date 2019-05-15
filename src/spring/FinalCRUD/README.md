# Spring-Hibernate

---

## Final Project

This is the final project that tries to combine every basic the Spring framework hast to offer.\
So the project is about a webbased CRUD application created with Spring Boot.\
The application can create read update and delete employees from the database with Hibernate.\
All the operations are called via REST (POST, GET, PUT, DELETE and OPTIONS)\
To add security to the application only authorized users from the database have role based access to specific routes.

So this little project contains the following basics of Spring:

Framework | Usecase
----|----
Spring Boot | As application base.
Hibernate | As database management framework.
Spring MVC | As application design and web design.
Thymeleaf | As frontend framework.
REST | As communication layer between client and server.
Spring Security | As authorisation and role framework.

You can simply download teh `FinalCRUD` directory and import as Maven Project to run it by your own.\
**Care:** Modify the `application.properties`. So that the database connection fits to your database.


Database script:
```sql
create database if not exists  demodb
create table employee
(
  id int auto_increment primary key,
  first_name varchar(64) null,
  last_name varchar(64) null,
  email varchar(128) null
);

INSERT INTO demodb.employee (id, first_name, last_name, email) VALUES (1, 'John', 'Doe', 'Johns@Testmail.com');
```