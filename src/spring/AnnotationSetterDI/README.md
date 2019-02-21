# Spring-Hibernate

---

## Annotation Setter DI

The MyApp is pure static and the class needs to be modified to get another object or other dependency generated.

The HelloSpringApp instead reads the applicationContext.xml, searches for classes with the annotation "Component" and loads them. If we want to instantiate a bean it checks "Autowired" Methods and tries to load them. In our example when we instantiate the TrackCoach Spring realizes that a implementation of the FortuneServiceInterface is needed (setter Method) and searches for one. In our case it finds this dependency bean with the class HappyFortuneService and adds an instance of this class to the constructor of our TrackCoach bean before returning the bean. 

You can add the Autowired Annotation to any method an Spring will try to call an 'inject' this method when creating the bean.

---

