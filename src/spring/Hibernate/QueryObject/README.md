# Spring-Hibernate

---

## Hibernate Query Objects

This is just a very basic example of how to use Hibernate to get a object from the database with a query and an entity class just by using the "createQuery" and "getResultList" methods.\
The annotation "Column" defines what column this property refers to and the "Entity" and "Table" annotation define that this class is an entity and refers to the database table form "Table".
The config file for Hibernate is in the src directory and contains all the properties to create a connection to the database and defines the log level etc.

To get the code working for you you need to modify the connection properties of the config file in the src directory and create a table called "student" with the columns "id" INT PRIMARY_KEY and AUTO-INCREMENT, "first_name" VARCHAR(45), "last_name" VARCHAR(45) and "email" VARCHAR(45).
 