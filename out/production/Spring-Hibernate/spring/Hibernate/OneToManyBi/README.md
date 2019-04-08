# Spring-Hibernate

---

## Hibernate Advanced One to Many / Many to One Bidirectional

This is just a very basic example of how to use Hibernate to get a one to many / many to one bidirectional connection between two objects from the database.\
The annotation "OneToMany" defines the connection type between two tables and the annotation "JoinColumn" defines the key to connect these two.\
This time also the "Instructor" gets a property list "Course" and links it with the annotation "OneToMany" and the attribute mapped by, that connects the Course class with the Instructor class.
The config file for Hibernate is in the src directory and contains all the properties to create a connection to the database and defines the log level etc.

To get the code working for you you need to modify the connection properties of the config file in the src directory and use the following sql database:\
```sql
create table course
(
  id            int auto_increment
    primary key,
  title         varchar(128) null,
  instructor_id int          null,
  constraint courde_title_uindex
    unique (title),
  constraint course_instructor_id_fk
    foreign key (instructor_id) references instructor (id)
);


create table instructor
(
  id                   int auto_increment
    primary key,
  first_name           varchar(45) null,
  last_name            varchar(45) null,
  instructor_detail_id int         null,
  constraint FK_DETAIL
    foreign key (instructor_detail_id) references instructor_detail (id)
);

create index FK_DETAIL_idx
  on instructor (instructor_detail_id);

INSERT INTO springhibernate.instructor (id, first_name, last_name, instructor_detail_id) VALUES (1, 'John', 'Doe', 1);
create table instructor_detail
(
  id    int auto_increment
    primary key,
  email varchar(128) null,
  hobby varchar(45)  null
);

INSERT INTO springhibernate.instructor_detail (id, email, hobby) VALUES (1, 'test@mail.com', 'swimming');
create table student
(
  id         int auto_increment
    primary key,
  first_name varchar(45) null,
  last_name  varchar(45) null,
  email      varchar(45) null
);

INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (1, 'Jooo', 'JonJon', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (3, 'Josef', 'JonNoe', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (6, 'Josef', 'JonNoe', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (7, 'Josef', 'JonNoe', 'thenewemial@test.com');
```
