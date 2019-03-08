# Spring-Hibernate

---

## Annotation Default Inversion of Control

The MyApp is pure static and the class needs to be modified to get another object generated.

The HelloSpringApp instead reads the applicationContext.xml and searches for annotation beans in the directory. Afterwards we can create and use the bean. If we want another object to be our bean we have to either change the annotation or use another annotation.

The difference to Annotation Explicit IoC is, that this time we won't give the Component Annotation a specific name/id like "myCoach". Instead we let Spring generate a name/id for us. Spring uses the class name and put's the first letter to lower case for the bean name/id.

---