# Spring-Hibernate

---

## Hibernate Advanced One to One Bidirectional

This is just a very basic example of how to use Hibernate to get a one to one bidirectional connection between two objects from the database.\
The annotation "OneToOne" defines the connection type between two tables and the annotation "JoinColumn" defines the key to connect these two.\
This time also the "InstructorDetail" gets a property "Instructor" and links it with the annotation "OneToOne" and the attribute mapped by, that connects the Detail class with the Entity class.
The config file for Hibernate is in the src directory and contains all the properties to create a connection to the database and defines the log level etc.

To get the code working for you you need to modify the connection properties of the config file in the src directory and use the sql database from the previous units:\
