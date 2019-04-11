# Spring-Hibernate

---

## Hibernate Advanced Many to Many

This is just a very basic example of how to use Hibernate to get a many to many connection between two objects from the database.\
The annotation "ManyToMany" defines the connection type between two tables, the attribute "name" defines the connection table, the attribute "joinColumns" the column on the own side to connect to to the connection table and the annotation "inverseJoinColumns" the column to connect the other table to the connection table.\

The config file for Hibernate is in the src directory and contains all the properties to create a connection to the database and defines the log level etc.

To get the code working for you you need to modify the connection properties of the config file in the src directory and use the following sql database:
```sql
create table course
(
  id int auto_increment primary key,
  title varchar(128) null,
  instructor_id int null,
  constraint courde_title_uindex
    unique (title),
  constraint course_instructor_id_fk
    foreign key (instructor_id) references instructor (id)
);

INSERT INTO springhibernate.course (id, title, instructor_id) VALUES (1, 'Math', 1);
INSERT INTO springhibernate.course (id, title, instructor_id) VALUES (2, 'Latin', 2);
INSERT INTO springhibernate.course (id, title, instructor_id) VALUES (3, 'Physics', 2);
create table course_student
(
  course_id int null,
  student_id int null,
  constraint course_student_course_id_fk
    foreign key (course_id) references course (id),
  constraint course_student_student_id_fk
    foreign key (student_id) references student (id)
);

INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (1, 1);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (2, 1);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (3, 6);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (1, 3);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (1, 6);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (2, 3);
INSERT INTO springhibernate.course_student (course_id, student_id) VALUES (3, 3);
create table instructor
(
  id int auto_increment primary key,
  first_name varchar(45) null,
  last_name varchar(45) null,
  instructor_detail_id int null,
  constraint FK_DETAIL
    foreign key (instructor_detail_id) references instructor_detail (id)
);

create index FK_DETAIL_idx
  on instructor (instructor_detail_id);

INSERT INTO springhibernate.instructor (id, first_name, last_name, instructor_detail_id) VALUES (1, 'John', 'Doe', 1);
INSERT INTO springhibernate.instructor (id, first_name, last_name, instructor_detail_id) VALUES (2, 'Joe', 'Jon', null);
create table instructor_detail
(
  id int auto_increment primary key,
  email varchar(128) null,
  hobby varchar(45)  null
);

INSERT INTO springhibernate.instructor_detail (id, email, hobby) VALUES (1, 'test@mail.com', 'swimming');
create table review
(
  id int auto_increment primary key,
  comment varchar(128) null,
  course_id int null,
  constraint review_course_id_fk
    foreign key (course_id) references course (id)
);


create table student
(
  id int auto_increment primary key,
  first_name varchar(45) null,
  last_name varchar(45) null,
  email varchar(45) null
);

INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (1, 'Jooo', 'JonJon1', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (3, 'Josef', 'JonNoe2', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (6, 'Josef', 'JonNoe3', 'thenewemial@test.com');
INSERT INTO springhibernate.student (id, first_name, last_name, email) VALUES (7, 'Josef', 'JonNoe4', 'thenewemial@test.com');
```
