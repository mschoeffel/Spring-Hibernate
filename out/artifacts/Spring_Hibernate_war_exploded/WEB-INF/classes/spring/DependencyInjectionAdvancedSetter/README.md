# Spring-Hibernate

---

## Dependency Injection Advanced Setter

The MyApp is pure static and the class needs to be modified to get another object or other dependency generated.

The HelloSpringApp instead reads the applicationContext.xml and generates the object with the gained information and dependency's and calls the setter methods of the dependency's. This time it also sets the Email and Team of the object. So only the XML-File has to be changed if you want another object to be generated, a dependency changes or you want to change a setter value.

---

What Spring does when creating the Coach bean, it creates the Coach bean and then creates the dependency object and calls the setter method of the Coach bean an sets the dependency object to the Coach bean. Afterwards it calls the other setters and set's the defines values before returning the object.