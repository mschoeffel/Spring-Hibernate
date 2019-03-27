# Spring-Hibernate

---

## Hibernate Advanced One to One Unidirectional

This is just a very basic example of how to use Hibernate to get a one to one unidirectional connection between two objects from the database.\
The annotation "OneToOne" defines the connection type between two tables and the annotation "JoinColumn" defines the key to connect these two.
The config file for Hibernate is in the src directory and contains all the properties to create a connection to the database and defines the log level etc.

To get the code working for you you need to modify the connection properties of the config file in the src directory and use the following sql script:\
```sql
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


create table instructor_detail
(
  id    int auto_increment
    primary key,
  email varchar(128) null,
  hobby varchar(45)  null
);
```
 