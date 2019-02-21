# Spring-Hibernate

---

## Annotation Qualifier DI

This time we got 2 or more implementations of the Interface FortuneService. So Spring doesnt know which exact implementation to inject to the TrackCoach. So we have to use the Qualifier Annotation so specify which exact bean we want to get inject.

If we won't use this Annotation here we would get a Spring Error "NoUniqueBeanDefinition". 

---

