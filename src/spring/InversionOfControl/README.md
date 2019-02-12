# Spring-Hibernate

---

## Inversion of Control

I know this isn't the best practice, because:

"[...] The whole idea of Inversion of Control is to have none of your classes know or care how they get the objects they depend on. This makes it easy to change what type of implementation of a given dependency you use at any time. It also makes the classes easy to test, as you can provide mock implementations of dependencies. Finally, it makes the classes simpler and more focused on their core responsibility.[...]" [StackOverflow Question [812415](https://stackoverflow.com/questions/812415/why-is-springs-applicationcontext-getbean-considered-bad)]

In another example I'll show how to make it better. But for now this is the easiest way to get some sort of "Inversion of Control".

The MyApp is pure static and the class needs to be modified to get another object generated.

The HelloSpringApp instead reads the applicationContext.xml and generates the object with the gained information. So only the XML-File has to be changed if you want another object to be generated.
