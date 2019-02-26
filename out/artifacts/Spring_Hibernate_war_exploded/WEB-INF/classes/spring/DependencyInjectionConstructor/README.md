# Spring-Hibernate

---

## Dependency Injection Constructor

The MyApp is pure static and the class needs to be modified to get another object or other dependency generated.

The HelloSpringApp instead reads the applicationContext.xml and generates the object with the gained information and dependency's. So only the XML-File has to be changed if you want another object to be generated or a dependency changes.

---
What Spring does when creating the Coach bean, it also creates the dependency's of the bean an injects them to the constructor of the Coach bean.
