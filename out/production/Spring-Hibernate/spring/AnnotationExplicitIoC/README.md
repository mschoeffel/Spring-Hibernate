# Spring-Hibernate

---

## Annotation Explicit Inversion of Control

The MyApp is pure static and the class needs to be modified to get another object generated.

The HelloSpringApp instead reads the applicationContext.xml and searches for annotation beans in the directory. Afterwards we can create and use the bean. If we want another object to be our bean we have to either change the annotation or use another annotation.

---