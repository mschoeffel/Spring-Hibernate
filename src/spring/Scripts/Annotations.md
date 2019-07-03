# Top Spring Annotations

## Table of Content

Number | Annotation
----|----
[1.1](#a-1-1) | @Component
[1.2](#a-1-2) | @Service
[1.3](#a-1-3) | @Repository
[1.4](#a-1-4) | @Controller
[1.5](#a-1-5) | @ComponentScan
&nbsp; | &nbsp;
[2.1](#a-2-1) | @Autowired
[2.2](#a-2-2) | @Qualifier
&nbsp; | &nbsp;
[3.1](#a-3-1) | @Configuration
[3.2](#a-3-2) | @Bean
&nbsp; | &nbsp;
[4.1](#a-4-1) | @RequestMapping
[4.2](#a-4-2) | @PathVariable
[4.3](#a-4-3) | @RequestParam
[4.4](#a-4-4) | @RequestBody

----

## <a name="a-1-1"></a>1.1 @Component
At its heart, Spring is a DI framework. In essence, a DI framework is responsible for **injecting** dependencies - in the form of Java beans - into other beans. This paradigm is the opposite of most basic applications, which directly instantiate their dependencies. In DI, however, beans are created with a level of indirection, expecting a DI framework to inject the dependencies for them. For example, a well-designed bean would have a constructor with a parameter for the dependency - and allow the DI framework to pass in an object that satisfies that dependency upon construction - rather than directly instantiating the dependency in the constructor. This reversal is called Inversion of Control (IoC) and is the basis upon which many of the various Spring libraries rest:
```java
public class Bar {}
// The non-DI way
public class Foo {
    private final Bar bar;
    public Foo() {
        this.bar = new Bar();
    }
}
// The DI way
public class Foo {
    private final Bar bar;
    public Foo(Bar bar) {
        this.bar = bar;
    }
}
```
One of the most critical questions for a DI framework to answer is: Which beans are **candidates** to be injected into other beans? To answer this question, Spring provides the `@Component` annotation. Applying this annotation to class informs Spring that the class is a component and an object of this class can be instantiated and injected into another component. The `@Component` interface is applied to a class in the following manner:
```java
@Component
public class FooComponent {}
```
Although the `@Component` annotation suffices to inform Spring of the injectability of a bean; Spring also provides specialized annotations that can be used to create components with more meaningful contextual information.

## <a name="a-1-2"></a>1.2 @Service
The `@Service` annotation - as the name implies - denotes that a bean is a service. According to the official `@Service` annotation documentation:
> [The `@Service` annotation] indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."\
\
May also indicate that a class is a "Business Service Facade" (in the Core J2EE patterns sense), or something similar.

In general, the concept of service in enterprise applications is vague, but in the context of a Spring application, a service is any class that provides methods to interact with domain logic or external components without maintaining state that changes the overall behavior of the service. For example, a service may act on behalf of an application to obtain documents from a database or obtain data from an external REST API.
```java
@Service
public class FooService {}
```
While there is no definitive rule about the state of a service, services generally do not contain state in the way that domain objects do. For example, a REST client, cache, or connection pool would not be considered the state of a service in the same way that a name, address, and social security number would be regarded as the state of a domain object. In practice, `@Service` and `@Component` are often used interchangeably due to the all-encompassing definition of a service.

## <a name="a-1-3"></a>1.3 @Repostory
While `@Service` is intended for more a general purpose, the `@Repository` annotation is a specialization of the `@Component` annotation that is designed for components that interact with data sources, such as databases, and Data Access Objects (DAOs).
```java
@Repository
public class FooRepository {}
```
According to the official `@Repository` documentation:
> Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".\
\
Teams implementing traditional Java EE patterns such as "Data Access Object" may also apply this stereotype to DAO classes, though care should be taken to understand the distinction between Data Access Object and DDD-style repositories before doing so. This annotation is a general-purpose stereotype and individual teams may narrow their semantics and use as appropriate.

Apart from marking a specific class as a component dealing with data sources, the Spring Framework treats beans annotated with `@Repository` with special exception processing. To maintain a consistent data interface, Spring can translate the exceptions thrown by native repositories - such as SQL or Hibernate implementations - into general exceptions that can be handled uniformly. To include exception translation for classes annotated with `@Repository`, we instantiate a bean of type PersistenceExceptionTranslationPostProcessor (we will see in later sections how to use the `@Configuration` and `@Bean` annotations):
```java
@Configuration
public class FooConfiguration {
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslator() {
        return new PersistenceExceptionTranslationPostProcessor()
    }
}
```
Including this bean will inform Spring to look for all implementations of `PersistenceExceptionTranslator` and use these implementations, if possible, to translate native `RuntimeExceptions` into `DataAccessExceptions`. For more information on exception translation with the @Repository annotation, see the official Spring Data Access documentation.

## <a name="a-1-4"></a>1.4 @Controller
The last specialization of the `@Component` annotation is arguably the most commonly used of the trio. Spring Model-View-Controller (MVC) is one of the most popular portions of the Spring Framework and allows developers to easily create REST APIs using the `@Controller` annotation. This annotation, when applied to a class, instructs the Spring Framework that the class should be treated as a part of the web interface for the application.

Endpoints are created in this class by applying the `@RequestMapping` annotation to the methods of that class - where the value of the `@RequestMapping` annotation is the path (relative to the root path of the controller to which the API endpoints are bound), and the method is the Hypertext Transfer Protocol (HTTP) method to which the endpoint is bound. For example:
```java
@Controller
public class FooController {
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public List<Foo> findAllFoos() {
        // ... return all foos in the application ... 
    }
}
```
This would create an endpoint that listens on the `/foo` path for `GET` requests and returns a list of all `Foo` objects - represented as a JavaScript Object Notation (JSON) list by default - to the caller. For example, if the web application was started on `https://localhost`, the endpoint would be bound to `https://localhost/foo`. We will cover the `@RequestMapping` annotation in greater detail below, but for the time being, it suffices to know that the `@Controller` annotation is a potent part of the Spring Framework and one that instructs the Spring Framework to create large and complex web service implementations on our behalf.

## <a name="a-1-5"></a>1.5 @ComponentScan
As described in Creating Annotations in Java, annotations do not execute any logic in-and-of themselves. Instead, annotations are simply markers that denote some information about a construct, such as a class, method, or field. For the annotation to be useful, it must be processed. In the case of the `@Component` annotation - and its specializations - Spring does not know where to look to find all of the classes annotated with `@Component`.

To do so, we must instruct Spring which packages on the classpath should be **scanned**. During the scanning process, the Spring DI Framework processes each of the classes in the provided package, recording any classes that are annotated with `@Component` or specialization of `@Component`. Once the scanning process is complete, the DI framework is aware of which classes are eligible for injection.

To instruct Spring which packages to scan, we use the `@ComponentScan` annotation:
```java
@Configuration
@ComponentScan
public class FooConfiguration {
    // ...
}
```
In a later section, we will delve into the `@Configuration` annotation, but for the time being, it suffices to know that the `@Configuration` annotation instructs Spring that the annotated class provides configuration information to be used by the DI framework. By default - if no arguments are supplied to the `@ComponentScan` annotation - the package that contains the configuration, and all its subpackages, are scanned. To specify a package or set of packages, the `basePackages` field is used:
```java
@Configuration
@ComponentScan(basePackages = "com.example.foo")
public class FooConfiguration {
    // ...
}
```
In the above example, Spring would scan the package `com.example.fo`o and all of its subpackages for eligible components. If only one base package is provided, the `@ComponentScan` annotation can be simplified to `@ComponentScan("com.example.foo")`. If more than one `base package` is required, the basePackages field can be assigned a set of strings:
```java
@Configuration
@ComponentScan(basePackages = {"com.example.foo", "com.example.otherfoo"})
public class FooConfiguration {
    // ...
}
```

## <a name="a-2-1"></a>2.1 @Autowired
A second, vital question for any DI framework is: What are the dependencies that must be satisfied when creating a bean? To inform the Spring Framework which fields or constructor parameters we are expecting to be injected - or **wired** - with dependencies, Spring provides the `@Autowired` annotation. This annotation is usually applied to either fields or constructors - although it can be applied to setters as well (this usage is less common).

When applied to fields, Spring will inject a qualifying dependence directly into the field upon creation, even when there is no setter present:
```java
@Component
public class FooComponent {
    @Autowired
    private Bar bar;
}
```
This is a convenient means of injecting dependencies into a component, but it does create an issue when testing a class. For example, if we were to write a test fixture that exercises our `FooComponent` class, without including the Spring testing framework into our fixture, we would be unable to inject a mock `Bar` value into the `bar` field (without performing cumbersome reflection). We could instead add the `@Autowired` annotation to a constructor that accepts a `Bar` parameter and assigns it to the `bar` field:
```java
@Component
public class FooComponent {
    private final Bar bar;
    @Autowired
    public Foo(Bar bar) {
        this.bar = bar;
    }
}
```
This still allows us to directly instantiate objects of the `FooComponent` class with mock `Bar` implementations without burdening the fixture with Spring test configuration. For example, the following would be a valid JUnit test case (using Mockito for mocking):
```java
public class FooTest {
    @Test
    public void exerciseSomeFunctionalityOfFoo() {
        Bar mockBar = Mockito.mock(Bar.class);
        FooComponent foo = new FooComponent(mockBar);
        // ... exercise the FooComponent object ...
    }
}
```
Annotating the constructor with `@Autowired` also allows us to access and manipulate the injected `Bar` bean before assigning it to the `bar` field. For example, if we wanted to ensure that the injected `Bar` bean is never `null`, we can perform this check prior to assigning the supplied `Bar` bean to the `bar` field:
```java
@Component
public class FooComponent {
    private final Bar bar;
    @Autowired
    public FooComponent(Bar bar) {
        this.bar = Objects.requireNonNull(bar);
    }
}
```

## <a name="a-2-2"></a>2.2 @Qualifier
In some instances, there may be multiple candidates for a dependency. This causes a problem for Spring since it must decide on which specific beans to inject when creating a component, or fail if a single candidate cannot be decided upon. For example, the following code will throw a `NoUniqueBeanDefinitionException`:
```java
public interface FooDao {
    public List<Foo> findAll();
}
@Repository
public class HibernateFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using Hibernate ...
    }
}
@Repository
public class SqlFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using SQL ...
    }
}
@Controller
public class FooController {
    private final FooDao dao;
    @Autowired
    public FooController(FooDao dao) {
        this.dao = dao;
    }
}
```
Spring would not know whether to inject the `HibernateDooDao` or the `SqlFooDao` and would, therefore, throw a fatal `NoUniqueBeanDefinitionException`. To aid Spring in resolving which bean to select, we can use the `@Qualifier` annotation. By supplying a key to `@Qualifier` annotation that matches the name supplied to the `@Component` annotation (or any of its specialization) in conjunction with the `@Autowired` annotation, we can narrow the eligible injection candidates. For example, in the following snippet, the `HibernateFooDao` would be injected into the `FooController` and no `NoUniqueBeanDefinitionException` would be thrown:
```java
public interface FooDao {
    public List<Foo> findAll();
}
@Repository("hibernateDao")
public class HibernateFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using Hibernate ...
    }
}
@Repository("sqlDao")
public class SqlFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using SQL ...
    }
}
@Controller
public class FooController {
    private final FooDao dao;
    @Autowired
    @Qualifier("hibernateDao")
    public FooController(FooDao dao) {
        this.dao = dao;
    }
}
```

## <a name="a-3-1"></a>3.1 @Configuration
Due to the enormous scale of the Spring Framework - dealing with everything from DI to MVC to transaction management-a level of developer-supplied configuration is needed. For example, if we wish to define a set of beans that can be used for autowiring - such as the `PersistenceExceptionTranslationPostProcessor` bean seen above - we must inform Spring with some configuration mechanism. Spring provides this mechanism through the aptly named `@Configuration` annotation. When this annotation is applied to a class, Spring treats that class as if it contains configuration information that can be used to parameterize the framework. According to the official Spring `@Configuration` documentation:
> Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:

## <a name="a-3-2"></a>3.2 @Bean
As we saw above, we can manually create new beans that Spring will include as candidates for injection without annotating the class itself. This may be the case when we do not have access to the source code for the class or the class exists in a package that is not part of the component scanning process. In the case of our `@Qualifier` example above, we could also forego the `@Repository` annotations and use the `@Bean` annotation inside a class annotated with `@Configuration` to instruct Spring to use the `HibernateFooDao` when a `FooDao` is needed:
```java
public interface FooDao {
    public List<Foo> findAll();
}
public class HibernateFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using Hibernate ...
    }
}
public class SqlFooDao implements FooDao {
    @Override
    public List<Foo> findAll() {
        // ... find all using SQL ...
    }
}
@Configuration
public class FooConfiguration {
    @Bean
    public FooDao fooDao() {
        return new HibernateFooDao(); 
    }
}
```
Using this configuration, Spring will now have the logic necessary to instantiate a `HibernateDooDao` when a `FooDao` is requested. In essence, we have created a Factory Method that the framework can use to instantiate instances of `FooDao` when needed. If an `@Autowired` parameter is excepted when creating a bean, we can object that dependency by adding a parameter to the method annotated with `@Bean`. If we annotate the component with `@Component` - or any specialization of `@Component` - Spring would know to inject the dependency when creating the component, but because we are calling the constructor directly - outside the Spring Framework - we must supply the dependency. For example:
```java
@Component
public class Bar {}
public class FooComponent {
    private final Bar bar;
    @Autowired
    public FooComponent(Bar bar) {
        this.bar = bar;
    }
}
@Configuration
public class FooConfiguration {
    @Bean
    public FooComponent fooComponent(Bar bar) {
        return new FooComponent(bar);
    }
}
```
Spring looks for registered candidates that satisfy the `fooComponent` method parameters and when one is found, it is passed in and eventually passed to the `FooComponent` constructor. Note that any bean annotated with `@Component` - or any specialization - or a bean created using another `@Bean` method can be injected into the `@Bean` method parameters. For example:
```java
public class Bar {}
public class FooComponent {
    private final Bar bar;
    @Autowired
    public FooComponent(Bar bar) {
        this.bar = bar;
    }
}
@Configuration
public class FooConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }
    @Bean
    public FooComponent fooComponent(Bar bar) {
        return new FooComponent(bar);
    }
}
```
Note that is a convention to name the method annotated with `@Bean` the same as the bean, with the first letter lowercase. For example, if we are creating a `FooComponent`, the method used to create the bean - and annotated with `@Bean` - is usually called `fooComponent`.

## <a name="a-4-1"></a>4.1 @RequestMapping
A large portion of the functionality of the `@Controller` annotation is derived from the `@RequestMapping` annotation, which instructs Spring to create a web endpoint that maps to the annotated method. When creating web API, a framework needs to know how to handle requests made to a specific path. For example, if an HTTP `GET` call is made to `https://localhost/foo`, Spring needs to know how to handle that request. This binding - or mapping - process is the purview of the `@RequestMapping` annotation, which informs Spring that a specific HTTP verb and path should be mapped to a specific method. For example, in a previous section, we saw that we could instruct Spring to map an HTTP `GE`T to `/foo` using the following snippet:
```java
@Controller
public class FooController {
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public List<Foo> findAll() {
        // ... return all foos in the application ... 
    }
}
```
Note that multiple HTTP verbs can be supplied to the method parameter, but this is abnormal in practice. Since a single HTTP verb is almost always provided to the method parameter - and these verbs usually end up being `GET`, `POST`, `PUT`, and `DELETE` - Spring also includes four additional annotations that can be used to simplify the creation of `@RequestMapping` methods:

* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`

If a root path is desired (i.e. a path matching the path of the controller), no value parameter is needed. The `@RequestMapping` annotation can also be applied to the controller itself, which sets the root path for the entire controller. For example, the following controller creates a `GET` endpoint at the `/foo` path and another `POST` endpoint at `/foo/bar`:
```java
@Controller
@RequestMapping("/foo")
public class FooController {
    @GetMapping
    public List<Foo> findAll() {
        // ... return all foos in the application ... 
    }
    @PostMapping("/bar")
    public void doSomething() {
        // ... do something ...
    }
}
```

## <a name="a-4-2"></a>4.2 @PathVariable
In some cases, a **path variable** may be supplied in the path, which is needed for properly handling the request. To obtain the value of this path variable, a parameter can be provided to the method annotated with `@RequestMapping` and the `@PathVariable` annotation can be applied to this parameter. For example, if the ID of an entity is needed to `DELETE` it, the ID can be provided as a path variable, such as a `DELETE` request to `/foo/1`. In order to capture the `1` supplied to the method responsible for handling the `DELETE` request, we capture the path variable by enclosing the variable name with curly braces and applying the `@PathVariable` annotation for a parameter of the handler method, where the value supplied to the `@PathVariabl`e matches the name of the variable captured in the path:
```java
@Controller
public class FooController {
    @DeleteMapping("/foo/{id}")
    public void deleteById(@PathVariable("id") String id) {
        // ... delete Foo with ID "id" ... 
    }
}
```
By default, the name of the `@PathVariable` is assumed to match the name of the annotated parameter, so if the name of the parameter exactly matches the name of the captured variable in the path, no value needs to be supplied to `@PathVariable` annotation:
```java
@Controller
public class FooController {
    @DeleteMapping("/foo/{id}")
    public void deleteById(@PathVariable String id) {
        // ... delete Foo with ID "id" ... 
    }
}
```
Spring will attempt to coerce the captured path variable into the data type of the parameter annotated with `@PathVariable`. For example, if we except the value of the ID path variable to be an integer, we could change the data type of the id parameter to `int`:
```java
@Controller
public class FooController {
    @DeleteMapping("/foo/{id}")
    public void deleteById(@PathVariable int id) {
        // ... delete Foo with ID "id" ... 
    }
}
```
If a value, such as the string `baz`, is supplied in the path (i.e., `/foo/baz`), an error will occur.

## <a name="a-4-3"></a>4.3 @RequestParam
Apart from capturing path variables, we can also capture **query parameters** using the `@RequestParam` annotation. The `@RequestParam` decorates a parameter to the handler method in the same manner as the `@PathVariable` annotation, but the value supplied to the `@RequestParam` annotation matches the key of the query parameter. For example, if we expect that an HTTP `GET` call will be made to a path of `/foo?limit=100`, we can create the following controller to capture the `limit` value:
```java
@Controller
public class FooController {
    @GetMapping("/foo")
    public List<Foo> findAll(@QueryParam("limit") int limit) {
        // ... return all Foo objects up to supplied limit ... 
    }
}
```
Just as with `@PathVariable`, the value supplied to the `@RequestParam` annotation can be omitted, and the name of the parameter will be used by default. Likewise, Spring will coerce the value of the captured query parameter into the type of the parameter, if possible (in the case above, to `int`).

## <a name="a-4-4"></a>4.4 @RequestBody
n cases where a request body is supplied in a call -commonly done with `POST` or `PUT` calls that create or update entries - Spring provides the `@RequestBody` annotation. As with the previous two annotations, the `@RequestBody` annotation is applied to a parameter of the handler method. Spring will then deserialize the supplied request body into the type of the parameter. For example, we can create a new `Foo` with an HTTP call that has a request body similar to the following:
```json
{"name": "some foo", "anotherAttribute": "bar"}
```
We can then create a class that encompasses fields that match the expected request body and create a handler method that captures this request body:
```java
public class FooRequest {
    private String name;
    private String anotherAttribute;
    public void setName(String name) {
        this.name = name; 
    }
    public String getName() {
        return name;
    }
    public void setAnotherAttribute(String anotherAttribute) {
        this.anotherAttribute = anotherAttribute;
    }
    public String getAnotherAttribute() {
        return anotherAttribute;
    }
}
@Controller
public class FooController {
    @PostMapping("/foo")
    public void create(@RequestBody FooRequest request) {
        // ... create a new Foo object using the request body ...
    }
}
```