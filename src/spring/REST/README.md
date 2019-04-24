# Spring-Hibernate

---

## Spring REST
Here I'll show an example how to code a Spring REST Application.

#### 56. / 57.
First there are some basics to convert a Java object into a json and vice versa. First you have to set up a new project and copy the classes and folders from this directory. I used Maven so therefore you need the following Maven pom.xml dependency to get the code working for you (also take care to mark the resources directory as resources):
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

Jackson is a quite popular project for creating REST applications and serializing and deserializing objects.

The class ConvertPojoJson shows how easy you can convert a POJO to a JSON and the other way round. When creating the JSON out of a POJO you have to care that the JSON file may be created in the target or out directory depending on your compiler.