# Spring-Hibernate

---

## Annotation Field DI

The MyApp is pure static and the class needs to be modified to get another object or other dependency generated.

The HelloSpringApp instead reads the applicationContext.xml, searches for classes with the annotation "Component" and loads them. If we want to instantiate a bean it checks "Autowired" Fields and tries to fill them. In our example when we instantiate the TrackCoach Spring realizes that a implementation of the FortuneServiceInterface is needed (field) and searches for one. In our case it finds this dependency bean with the class HappyFortuneService and adds an instance of this class to the field of our TrackCoach bean before returning the bean. 

You can add the Autowired Annotation to any field and Spring will try to fill this field when creating the bean.

---

