# Spring-Hibernate

---

## Dependency Injection Setter

The MyApp is pure static and the class needs to be modified to get another object or other dependency generated.

The HelloSpringApp instead reads the applicationContext.xml and generates the object with the gained information and dependency's and calls the setter methods of the dependency's. So only the XML-File has to be changed if you want another object to be generated or a dependency changes.

---

What Spring does when creating the Coach bean, it creates the Coach bean and then creates the dependency object and calls the setter method of the Coach bean an sets the dependency object to the Coach bean. 