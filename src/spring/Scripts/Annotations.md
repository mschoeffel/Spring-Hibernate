# Top Spring Annotations

## Table of Content

Number | Annotation
----|----
**Spring Core** | &nbsp;
[1.1](#a-1-1) | @Required
[1.2](#a-1-2) | @ComponentScan
[1.3](#a-1-3) | @Autowired
[1.4](#a-1-4) | @Qualifier
[1.5](#a-1-5) | @Configuration
[1.6](#a-1-6) | @Bean
[1.7](#a-1-7) | @Lazy
[1.8](#a-1-8) | @Value
&nbsp; | &nbsp;
**Stereotype** | &nbsp;
[2.1](#a-2-1) | @Component
[2.2](#a-2-2) | @Controller
[2.3](#a-2-3) | @Service
[2.4](#a-2-4) | @Repository
&nbsp; | &nbsp;
**Spring Boot** | &nbsp;
[3.1](#a-3-1) | @EnableAutoConfiguration
[3.2](#a-3-2) | @SpringBootApplication
&nbsp; | &nbsp;
**Spring MVC & REST** | &nbsp;
[4.1](#a-4-1) | @Controller
[4.2](#a-4-2) | @RequestMapping
[4.3](#a-4-3) | @CookieValue
[4.4](#a-4-4) | @CrossOrigin
&nbsp; | &nbsp;
**Request Mappings** | &nbsp;
[5.1](#a-5-1) | @RequestMapping
[5.2](#a-5-2) | @GetMapping
[5.3](#a-5-3) | @PostMapping
[5.4](#a-5-4) | @PutMapping
[5.5](#a-5-5) | @PatchMapping
[5.6](#a-5-6) | @DeleteMapping
[5.7](#a-5-7) | @ExceptionHandler
[5.8](#a-5-8) | @InitBinder
[5.9](#a-5-9) | @Mappings and @Mapping
[5.10](#a-5-10) | @MatrixVariable
[5.11](#a-5-11) | @PathVariable
[5.12](#a-5-12) | @RequestAttribute
[5.13](#a-5-13) | @RequestBody
[5.14](#a-5-14) | @RequestHeader
[5.15](#a-5-15) | @RequestParam
[5.16](#a-5-16) | @RequestPart
[5.17](#a-5-17) | @ResponseBody
[5.18](#a-5-18) | @ResponseStatus
[5.19](#a-5-19) | @ControllerAdvice
[5.20](#a-5-20) | @RestController
[5.21](#a-5-21) | @RestControllerAdvice
[5.22](#a-5-22) | @SessionAttribute
[5.23](#a-5-23) | @SessionAttributes
&nbsp; | &nbsp;
**Cloud** | &nbsp;
[6.1](#a-6-1) | @EnableConfigServer
[6.2](#a-6-2) | @EnableEurekaServer
[6.3](#a-6-3) | @EnableDiscoveryClient
[6.4](#a-6-4) | @EnableCircuitBreaker
[6.5](#a-6-5) | @HystrixCommand
&nbsp; | &nbsp;
**Data Access** | &nbsp;
[7.1](#a-7-1) | @Transactional
&nbsp; | &nbsp;
**Cache** | &nbsp;
[8.1](#a-8-1) | @Cacheable
[8.2](#a-8-2) | @CachePut
[8.3](#a-8-3) | @CacheEvict
[8.4](#a-8-4) | @CacheConfig
&nbsp; | &nbsp;
**Scheduling & Tasks** | &nbsp;
[9.1](#a-9-1) | @Scheduled
[9.2](#a-9-2) | @Async
&nbsp; | &nbsp;
**Testing** | &nbsp;
[10.1](#a-10-1) | @BootstrapWith
[10.2](#a-10-2) | @ContextConfiguration
[10.3](#a-10-3) | @WebAppConfiguration
[10.4](#a-10-4) | @Timed
[10.5](#a-10-5) | @Repeat
[10.6](#a-10-6) | @Commit
[10.7](#a-10-7) | @RollBack
[10.8](#a-10-8) | @DirtiesContext
[10.9](#a-10-9) | @BeforeTransaction
[10.10](#a-10-10) | @AfterTransaction
[10.11](#a-10-11) | @Sql
[10.12](#a-10-12) | @SqlConfig
[10.13](#a-10-13) | @SqlGroup
[10.14](#a-10-14) | @SpringBootTest
[10.15](#a-10-15) | @DataJpaTest
[10.16](#a-10-16) | @DataMongoTest
[10.17](#a-10-17) | @WebMVCTest
[10.18](#a-10-18) | @AutoConfigureMockMVC
[10.19](#a-10-19) | @MockBean
[10.20](#a-10-20) | @JsonTest
[10.21](#a-10-21) | @TestPropertySource

----

# Spring Core
## <a name="a-1-1"></a>1.1 @Required
This annotation is applied to bean setter methods. Consider a scenario where you need to enforce a required property. The `@Required` annotation indicates that the affected bean must be populated at configuration time with the required property. Otherwise, an exception of type `BeanInitializationException` is thrown.

## <a name="a-1-2"></a>1.2 @ComponentScan
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

## <a name="a-1-3"></a>1.3 @Autowired
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

## <a name="a-1-4"></a>1.4 @Qualifier
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

## <a name="a-1-5"></a>1.5 @Configuration
Due to the enormous scale of the Spring Framework - dealing with everything from DI to MVC to transaction management-a level of developer-supplied configuration is needed. For example, if we wish to define a set of beans that can be used for autowiring - such as the `PersistenceExceptionTranslationPostProcessor` bean seen above - we must inform Spring with some configuration mechanism. Spring provides this mechanism through the aptly named `@Configuration` annotation. When this annotation is applied to a class, Spring treats that class as if it contains configuration information that can be used to parameterize the framework. According to the official Spring `@Configuration` documentation:
> Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:

## <a name="a-1-6"></a>1.6 @Bean
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

## <a name="a-1-7"></a>1.7 @Lazy
This annotation is used on component classes. By default, all autowired dependencies are created and configured at startup. But if you want to initialize a bean lazily, you can use the `@Lazy` annotation over the class. This means that the bean will be created and initialized only when it is first requested for. You can also use this annotation on `@Configuration` classes. This indicates that all `@Bean` methods within that `@Configuration` should be lazily initialized.

## <a name="a-1-8"></a>1.8 @Value
This annotation is used at the field, constructor parameter, and method parameter levels. The `@Value` annotation indicates a default value expression for the field or parameter to initialize the property with. As the `@Autowired` annotation tells Spring to inject an object into another when it loads your application context, you can also use the `@Value` annotation to inject values from a property file into a bean’s attribute. It supports both #{...} and ${...} placeholders.


# Stereotype
## <a name="a-2-1"></a>2.1 @Component
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

## <a name="a-2-2"></a>2.2 @Controller
This specialization of the `@Component` annotation is arguably the most commonly used of the trio. Spring Model-View-Controller (MVC) is one of the most popular portions of the Spring Framework and allows developers to easily create REST APIs using the `@Controller` annotation. This annotation, when applied to a class, instructs the Spring Framework that the class should be treated as a part of the web interface for the application.

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

## <a name="a-2-3"></a>2.3 @Service
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

## <a name="a-2-4"></a>2.4 @Repository
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
Including this bean will inform Spring to look for all implementations of `PersistenceExceptionTranslator` and use these implementations, if possible, to translate native `RuntimeExceptions` into `DataAccessExceptions`. For more information on exception translation with the `@Repository` annotation, see the official Spring Data Access documentation.


# Spring Boot
## <a name="a-3-1"></a>3.1 @EnableAutoConfiguration
This annotation is usually placed on the main application class. The `@EnableAutoConfiguration` annotation implicitly defines a base “search package”. This annotation tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

## <a name="a-3-2"></a>3.2 @SpringBootApplication
This annotation is used on the application class while setting up a Spring Boot project. The class that is annotated with the `@SpringBootApplication` must be kept in the base package. The one thing that the `@SpringBootApplication` does is a component scan. But it will scan only its **sub-packages**. As an example, if you put the class annotated with `@SpringBootApplication` in `com.example`, then `@SpringBootApplication` will scan all its sub-packages, such as `com.example.a`, `com.example.b`, and `com.example.a.x`.

The `@SpringBootApplication` is a convenient annotation that adds all the following:

* `@Configuration`
* `@EnableAutoConfiguration`
* `@ComponentScan`


# Spring MVC & REST
## <a name="a-4-1"></a>4.1 @Controller
This annotation is used on Java classes that play the role of controller in your application. The `@Controller` annotation allows autodetection of component classes in the classpath and auto-registering bean definitions for them. To enable autodetection of such annotated controllers, you can add component scanning to your configuration. The Java class annotated with `@Controller` is capable of handling multiple request mappings.

This annotation can be used with Spring MVC and Spring WebFlux.

## <a name="a-4-2"></a>4.2 @RequestMapping
See the topic Request Mappings.

## <a name="a-4-3"></a>4.3 @CookieValue
This annotation is used at method parameter level. `@CookieValue` is used as an argument of a request mapping method. The HTTP cookie is bound to the `@CookieValue` parameter for a given cookie name. This annotation is used in the method annotated with `@RequestMapping`.
Let us consider that the following cookie value is received with an HTTP request:

`JSESSIONID=418AB76CD83EF94U85YD34W`

To get the value of the cookie, use `@CookieValue` like this:
```java

@ReuestMapping("/cookieValue")
    public void getCookieValue(@CookieValue "JSESSIONID" String cookie){
}
```

## <a name="a-4-4"></a>4.4 @CrossOrigin
This annotation is used both at the class and method levels to enable cross-origin requests. In many cases, the host that serves JavaScript will be different from the host that serves the data. In such a case, Cross Origin Resource Sharing (CORS) enables cross-domain communication. To enable this communication, you just need to add the `@CrossOrigin` annotation.

By default, the `@CrossOrigin` annotation allows all origin, all headers, the HTTP methods specified in the@RequestMapping annotation, and a maxAge of 30 min. You can customize the behavior by specifying the corresponding attribute values.

An example of using `@CrossOrigin` at both the controller and handler method levels is below:
```java
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {
    @CrossOrigin(origins = "http://example.com")
    @RequestMapping("/message")
    public Message getMessage() {
        // ...
    }
    @RequestMapping("/note")
    public Note getNote() {
        // ...
    }
}
```
In this example, both the `getExample()` and `getNote()` methods will have a `maxAge` of `3600` seconds. Also, `getExample()` will only allow cross-origin requests from `http://example.com`, while `getNote()` will allow cross-origin requests from all hosts.

# Request Mappings
## <a name="a-5-1"></a>5.1 @RequestMapping
A large portion of the functionality of the `@Controller` annotation is derived from the `@RequestMapping` annotation, which instructs Spring to create a web endpoint that maps to the annotated method. When creating web API, a framework needs to know how to handle requests made to a specific path. For example, if an HTTP `GET` call is made to `https://localhost/foo`, Spring needs to know how to handle that request. This binding - or mapping - process is the purview of the `@RequestMapping` annotation, which informs Spring that a specific HTTP verb and path should be mapped to a specific method. For example, in a previous section, we saw that we could instruct Spring to map an HTTP `GET` to `/foo` using the following snippet:
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

## <a name="a-5-2"></a>5.2 @GetMapping
This annotation is used for mapping HTTP `GET` requests onto specific handler methods. `@GetMapping` is a composed annotation that acts as a shortcut for `@RequestMapping(method = RequestMethod.GET)`.

## <a name="a-5-3"></a>5.3 @PostMapping
This annotation is used for mapping HTTP `POST` requests onto specific handler methods. `@PostMapping` is a composed annotation that acts as a shortcut for `@RequestMapping(method = RequestMethod.POST)`.

## <a name="a-5-4"></a>5.4 @PutMapping
This annotation is used for mapping HTTP `PUT` requests onto specific handler methods. `@PutMapping` is a composed annotation that acts as a shortcut for `@RequestMapping(method = RequestMethod.PUT)`.

## <a name="a-5-5"></a>5.5 @PatchMapping
This annotation is used for mapping HTTP `PATCH` requests onto specific handler methods. `@PatchMapping` is a composed annotation that acts as a shortcut for `@RequestMapping(method = RequestMethod.PATCH)`.

## <a name="a-5-6"></a>5.6 @DeleteMapping
This annotation is used for mapping HTTP `DELETE` requests onto specific handler methods. `@DeleteMapping` is a composed annotation that acts as a shortcut for `@RequestMapping(method = RequestMethod.DELETE)`.

## <a name="a-5-7"></a>5.7 @ExceptionHandler
This annotation is used at method levels to handle exceptions at the controller level. The `@ExceptionHandler` annotation is used to define the class of exception it will catch. You can use this annotation on methods that should be invoked to handle an exception. The `@ExceptionHandler` values can be set to an array of Exception types. If an exception is thrown that matches one of the types in the list, then the method annotated with the matching `@ExceptionHandler` will be invoked.

## <a name="a-5-8"></a>5.8 @InitBinder
This annotation is a method-level annotation that plays the role of identifying the methods that initialize theWebDataBinder — a DataBinder that binds the request parameter to JavaBean objects. To customize request parameter data binding, you can use `@InitBinder` annotated methods within our controller. The methods annotated with `@InitBinder` includes all argument types that handler methods support.

The `@InitBinder` annotated methods will get called for each HTTP request if you don’t specify the value element of this annotation. The value element can be a single or multiple form names or request parameters that the init binder method is applied to.

## <a name="a-5-9"></a>5.9 @Mappings and @Mapping
This annotation is used on fields. The `@Mapping` annotation is a meta-annotation that indicates a web mapping annotation. When mapping different field names, you need to configure the source field to its target field, and to do that, you have to add the `@Mappings` annotation. This annotation accepts an array of `@Mapping` having the source and the target fields.

## <a name="a-5-10"></a>5.10 @MatrixVariable
This annotation is used to annotate request handler method arguments so that Spring can inject the relevant bits of a matrix URI. Matrix variables can appear on any segment each separated by a semicolon. If a URL contains matrix variables, the request mapping pattern must represent them with a URI template. The `@MatrixVariable` annotation ensures that the request is matched with the correct matrix variables of the URI.

## <a name="a-5-11"></a>5.11 @PathVariable
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

## <a name="a-5-12"></a>5.12 @RequestAttribute
This annotation is used to bind the request attribute to a handler method parameter. Spring retrieves the named attribute's value to populate the parameter annotated with `@RequestAttribute`. While the `@RequestParam` annotation is used bind the parameter values from a query string, `@RequestAttribute` is used to access the objects that have been populated on the server side.

## <a name="a-5-13"></a>5.13 @RequestBody
In cases where a request body is supplied in a call -commonly done with `POST` or `PUT` calls that create or update entries - Spring provides the `@RequestBody` annotation. As with the previous two annotations, the `@RequestBody` annotation is applied to a parameter of the handler method. Spring will then deserialize the supplied request body into the type of the parameter. For example, we can create a new `Foo` with an HTTP call that has a request body similar to the following:
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

## <a name="a-5-14"></a>5.14 @RequestHeader
This annotation is used to annotate request handler method arguments. The `@RequestHeader` annotation is used to map controller parameter to request header value. When Spring maps the request, `@RequestHeader` checks the header with the name specified within the annotation and binds its value to the handler method parameter. This annotation helps you to get the header details within the controller class.

## <a name="a-5-15"></a>5.15 @RequestParam
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

## <a name="a-5-16"></a>5.16 @RequestPart
This annotation is used to annotate request handler method arguments. The `@RequestPart` annotation can be used instead of `@RequestParam` to get the content of a specific multipart and bind it to the method argument annotated with `@RequestPart`. This annotation takes into consideration the “Content-Type” header in the multipart (request part).

## <a name="a-5-17"></a>5.17 @ResponseBody
This annotation is used to annotate request handler methods. The `@ResponseBody` annotation is similar to the@RequestBody annotation. The `@ResponseBody` annotation indicates that the result type should be written straight in the response body in whatever format you specify like JSON or XML. Spring converts the returned object into a response body by using the HttpMessageConveter.

## <a name="a-5-18"></a>5.18 @ResponseStatus
This annotation is used on methods and exception classes. `@ResponseStatus` marks a method or exception class with a status code and a reason that must be returned. When the handler method is invoked the status code is set to the HTTP response which overrides the status information provided by any other means. A controller class can also be annotated with `@ResponseStatus`, which is then inherited by all `@RequestMapping` methods.

## <a name="a-5-19"></a>5.19 @ControllerAdvice
This annotation is applied at the class level. As explained earlier, for each controller, you can use `@ExceptionHandler` on a method that will be called when a given exception occurs. But this handles only those exceptions that occur within the controller in which it is defined. To overcome this problem, you can now use the `@ControllerAdvice` annotation. This annotation is used to define `@ExceptionHandler`, `@InitBinder`, and `@ModelAttribute` methods that apply to all `@RequestMapping` methods. Thus, if you define the `@ExceptionHandler` annotation on a method in a `@ControllerAdvice` class, it will be applied to all the controllers.

## <a name="a-5-20"></a>5.20 @RestController
This annotation is used at the class level. The `@RestController` annotation marks the class as a controller where every method returns a domain object instead of a view. By annotating a class with this annotation, you no longer need to add `@ResponseBody` to all the RequestMapping methods. It means that you no long use view-resolvers or send HTML in response. You just send the domain object as an HTTP response in the format that is understood by the consumers, like JSON.

`@RestController` is a convenience annotation that combines `@Controller` and `@ResponseBody`.

## <a name="a-5-21"></a>5.21 @RestControllerAdvice
This annotation is applied to Java classes. `@RestControllerAdvice` is a convenience annotation that combines `@ControllerAdvice` and `@ResponseBody`. This annotation is used along with the `@ExceptionHandler` annotation to handle exceptions that occur within the controller.

## <a name="a-5-22"></a>5.22 @SessionAttribute
This annotation is used at method parameter level. The `@SessionAttribute` annotation is used to bind the method parameter to a session attribute. This annotation provides a convenient access to the existing or permanent session attributes.

## <a name="a-5-23"></a>5.23 @SessionAttributes
This annotation is applied at the type level for a specific handler. The `@SessionAtrributes` annotation is used when you want to add a JavaBean object into a session. This is used when you want to keep the object in session for short lived. `@SessionAttributes` is used in conjunction with `@ModelAttribute`.

Consider this example:
```java
@ModelAttribute("person")
public Person getPerson() {}
// within the same controller as above snippet
@Controller
@SeesionAttributes(value = "person", types = {
    Person.class
})
public class PersonController {}
```
The `@ModelAttribute` name is assigned to the `@SessionAttributes` as a value. The `@SessionAttributes` has two elements. The value element is the name of the session in the model and the types element is the type of session attributes in the model.


# Cloud
## <a name="a-6-1"></a>6.1 @EnableConfigServer
This annotation is used at the class level. When developing a project with a number of services, you need to have a centralized and straightforward manner to configure and retrieve the configurations of all the services that you are going to develop. One advantage of using a centralized config server is that you don’t need to carry the burden of remembering where each configuration is distributed across multiple and distributed components.

You can use Spring Cloud’s `@EnableConfigServer` annotation to start a config server that the other applications can talk to.

## <a name="a-6-2"></a>6.2 @EnableEurekaServer
This annotation is applied to Java classes. One problem that you may encounter while decomposing your application into microservices is that it becomes difficult for every service to know the address of every other service it depends on. There comes the discovery service which is responsible for tracking the locations of all other microservices.

Netflix’s Eureka is an implementation of a discovery server and integration is provided by Spring Boot. Spring Boot has made it easy to design a Eureka Server by just annotating the entry class with `@EnableEurekaServer`.

## <a name="a-6-3"></a>6.3 @EnableDiscoveryClient
This annotation is applied to Java classes. In order to tell any application to register itself with Eureka, you just need to add the `@EnableDiscoveryClient` annotation to the application entry point. The application that’s now registered with Eureka uses the Spring Cloud Discovery Client abstraction to interrogate the registry for its own host and port.

## <a name="a-6-4"></a>6.4 @EnableCircuitBreaker
This annotation is applied to Java classes that can act as the circuit breaker. The circuit breaker pattern can allow a microservice continue working when a related service fails, preventing the failure from cascading. This also gives the failed service a time to recover.

The class annotated with `@EnableCircuitBreaker` will monitor, open, and close the circuit breaker.

## <a name="a-6-5"></a>6.5 @HystrixCommand
This annotation is used at the method level. Netflix’s Hystrix library provides the implementation of a Circuit Breaker pattern. When you apply the circuit breaker to a method, Hystrix watches for the failures of the method. Once failures build up to a threshold, Hystrix opens the circuit so that the subsequent calls also fail. Now Hystrix redirects calls to the method, and they are passed to the specified fallback methods.

Hystrix looks for any method annotated with the `@HystrixCommand` annotation and wraps it into a proxy connected to a circuit breaker so that Hystrix can monitor it.

Consider the following example:
```java
@Service
public class BookService {
    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "newList") 
    public String bookList() {
        URI uri = URI.create("http://localhost:8081/recommended");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String newList() {
        return "Cloud native Java";
    }
}
```
Here `@HystrixCommand` is applied to the original method `bookList()`. The `@HystrixCommand` annotation has `newList` as the fallback method. So for some reason, if Hystrix opens the circuit on `bookList()`, you will have a placeholder book list ready for the users.


# Data Access
## <a name="a-7-1"></a>7.1 @Transactional
This annotation is placed before an interface definition, a method on an interface, a class definition, or a public method on a class. The mere presence of `@Transactional` is not enough to activate the transactional behavior. The `@Transactional` is simply metadata that can be consumed by some runtime infrastructure. This infrastructure uses the metadata to configure the appropriate beans with transactional behavior.

The annotation further supports configuration like:
* The Propagation type of the transaction
* The Isolation level of the transaction
* A timeout for the operation wrapped by the transaction
* A read-only flag - a hint for the persistence provider that the transaction must be read onlyThe rollback rules for the transaction

# Cache
## <a name="a-8-1"></a>8.1 @Cacheable
This annotation is used on methods. The simplest way of enabling the cache behavior for a method is to annotate it with `@Cacheable` and parameterize it with the name of the cache where the results would be stored.
```java
@Cacheable("addresses")
public String getAddress(Book book){...}
```
In the snippet above, the method getAddress is associated with the cache named addresses. Each time the method is called, the cache is checked to see whether the invocation has been already executed and does not have to be repeated.

## <a name="a-8-2"></a>8.2 @CachePut
This annotation is used on methods. Whenever you need to update the cache without interfering the method execution, you can use the `@CachePut` annotation. That is, the method will always be executed and the result cached.
```java
@CachePut("addresses")
public String getAddress(Book book){...}
```
Using `@CachePut` and `@Cacheable` on the same method is strongly discouraged, as the former forces the execution in order to execute a cache update, the latter causes the method execution to be skipped by using the cache.

## <a name="a-8-3"></a>8.3 @CacheEvict
This annotation is used on methods. It is not that you always want to populate the cache with more and more data. Sometimes, you may want to remove some cache data so that you can populate the cache with some fresh values. In such a case, use the `@CacheEvict` annotation.
```java
@CacheEvict(value="addresses", allEntries="true")
public String getAddress(Book book){...}
```
Here, an additional element, `allEntries`, is used along with the cache name to be emptied. It is set to true so that it clears all values and prepares to hold new data.

## <a name="a-8-4"></a>8.4 @CacheConfig
This annotation is a class level annotation. The `@CacheConfig` annotation helps to streamline some of the cache information at one place. Placing this annotation on a class does not turn on any caching operation. This allows you to store the cache configuration at the class level so that you don’t have to declare things multiple times.


# Scheduling & Tasks
## <a name="a-9-1"></a>9.1 Scheduled
This annotation is a method-level annotation. The `@Scheduled` annotation is used on methods along with the trigger metadata. A method with `@Scheduled` should have a **void** return type and should not accept any parameters.

There are different ways of using the `@Scheduled` annotation:

### 1. Case:
```java
@Scheduled(fixedDelay=5000)
public void doSomething() {
    // something that should execute periodically   
}
```
In this case, the duration between the end of the last execution and the start of the next execution is fixed. The tasks always **wait** until the previous one is finished.

### 2. Case:
```java

@Scheduled(fixedRate=5000)
public void doSomething() { 
    // something that should execute periodically 
}
```
In this case, the beginning of the task execution **does not wait** for the completion of the previous execution.

### 3. Case:
```java

@Scheduled(initialDelay=1000,fixedRate=5000)
public void doSomething() { 
   // something that should execute periodically after an initial delay  
}
```
The task gets executed initially with a delay and then continues with the specified fixed rate.

## <a name="a-9-2"></a>9.2 Async
This annotation is used on methods to execute each method in a separate thread. The `@Async` annotation is provided on a method so that the invocation of that method will occur asynchronously. Unlike methods annotated with `@Scheduled`, the methods annotated with `@Async` can take arguments. They will be invoked in the normal way by callers at runtime rather than by a scheduled task.

`@Async` can be used with both void return type methods and methods that return a value. However, methods with return values must have a Future-typed return value.


# Testing
## <a name="a-10-1"></a>10.1 @BootstrapWith
This annotation is a class-level annotation. The `@BootstrapWith` annotation is used to configure how the Spring TestContext Framework is bootstrapped. This annotation is used as a metadata to create custom composed annotations and reduce the configuration duplication in a test suite.

## <a name="a-10-2"></a>10.2 @ContextConfiguration
This annotation is a class level annotation that defines a metadata used to determine which configuration files to use to the load the ApplicationContext for your test. More specifically `@ContextConfiguration` declares the annotated classes that will be used to load the context. You can also tell Spring where to locate the file.
```java
@ContextConfiguration(locations={"example/test-context.xml", loader = Custom ContextLoader.class})
```

## <a name="a-10-3"></a>10.3 @WebAppConfiguration
This annotation is a class level annotation. The `@WebAppConfiguration` is used to declare that the ApplicationContext loaded for an integration test should be a WebApplicationContext. This annotation is used to create the web version of the application context. It is important to note that this annotation must be used with the `@ContextConfiguration` annotation. The default path to the root of the web application is `src/main/webapp`. You can override it by passing a different path to the `@WebAppConfiguration`.

## <a name="a-10-4"></a>10.4 @Timed
This annotation is used on methods. The `@Timed` annotation indicates that the annotated test method must finish its execution at the specified time period (in milliseconds). If the execution exceeds the specified time in the annotation, the test fails.
```java
@Timed(millis=10000)
public void testLongRunningProcess() {  ... }
```
In this example, the test will fail if it exceeds 10 seconds of execution.

## <a name="a-10-5"></a>10.5 @Repeat
This annotation is used on test methods. If you want to run a test method several times in a row automatically, you can use the `@Repeat` annotation. The number of times that test method is to be executed is specified in the annotation.
```java
@Repeat(10)
@Test
public void testProcessRepeatedly() {  ... }
```
In this example, the test will be executed 10 times.

## <a name="a-10-6"></a>10.6 @Commit
This annotation can be used as both class-level or method-level annotation. After execution of a test method, the transaction of the transactional test method can be committed using the `@Commit` annotation. This annotation explicitly conveys the intent of the code. When used at the class level, this annotation defines the commit for all test methods within the class. When declared as a method level annotation, `@Commit` specifies the commit for specific test methods overriding the class level commit.

## <a name="a-10-7"></a>10.7 @RollBack
This annotation can be used as both class-level and method-level annotation. The `@RollBack` annotation indicates whether the transaction of a transactional test method must be rolled back after the test completes its execution. If this true, `@Rollback(true)`, the transaction is rolled back. Otherwise, the transaction is committed. `@Commit` is used instead of `@RollBack(false)`.

When used at the class level, this annotation defines the rollback for all test methods within the class.

When declared as a method level annotation, `@RollBack` specifies the rollback for specific test methods overriding the class level rollback semantics.

## <a name="a-10-8"></a>10.8 @DirtiesContext
This annotation is used as both class-level and method-level annotation. `@DirtiesContext` indicates that the Spring ApplicationContext has been modified or corrupted in some manner and it should be closed. This will trigger the context reloading before execution of next test. The ApplicationContext is marked as dirty before or after any such annotated method as well as before or after current test class.

The `@DirtiesContext` annotation supports `BEFORE_METHOD`, `BEFORE_CLASS`, and `BEFORE_EACH_TEST_METHOD` modes for closing the ApplicationContext before a test.

**NOTE:** Avoid overusing this annotation. It is an expensive operation and if abused, it can really slow down your test suite.

## <a name="a-10-9"></a>10.9 @BeforeTransaction
This annotation is used to annotate void methods in the test class. `@BeforeTransaction` annotated methods indicate that they should be executed before any transaction starts executing. That means the method annotated with `@BeforeTransaction` must be executed before any method annotated with `@Transactional`.

## <a name="a-10-10"></a>10.10 @AfterTransaction
This annotation is used to annotate void methods in the test class. `@AfterTransaction` annotated methods indicate that they should be executed after a transaction ends for test methods. That means the method annotated with `@AfterTransaction` must be executed after the method annotated with `@Transactional`.

## <a name="a-10-11"></a>10.11 @Sql
This annotation can be declared on a test class or test method to run SQL scripts against a database. The `@Sql` annotation configures the resource path to SQL scripts that should be executed against a given database either before or after an integration test method. When `@Sql` is used at the method level it, will override any `@Sql` defined in at class level.

## <a name="a-10-12"></a>10.12 @SqlConfig
This annotation is used along with the `@Sql` annotation. The `@SqlConfig` annotation defines the metadata that is used to determine how to parse and execute SQL scripts configured via the `@Sql` annotation. When used at the class level, this annotation serves as global configuration for all SQL scripts within the test class. But when used directly with the config attribute of `@Sql`, `@SqlConfig` serves as a local configuration for SQL scripts declared.

## <a name="a-10-13"></a>10.13 @SqlGroup
This annotation is used on methods. The `@SqlGroup` annotation is a container annotation that can hold several `@Sql` annotations. This annotation can declare nested `@Sql` annotations.
In addition, `@SqlGroup` is used as a meta-annotation to create custom composed annotations. This annotation can also be used along with repeatable annotations, where `@Sql` can be declared several times on the same method or class.

## <a name="a-10-14"></a>10.14 @SpringBootTest
This annotation is used to start the Spring context for integration tests. This will bring up the full autoconfigruation context.

## <a name="a-10-15"></a>10.15 @DataJpaTest
The `@DataJpaTest` annotation will only provide the autoconfiguration required to test Spring Data JPA using an in-memory database such as H2.

This annotation is used instead of `@SpringBootTest`.

## <a name="a-10-16"></a>10.16 @DataMongoTest
The `@DataMongoTest` will provide a minimal autoconfiguration and an embedded MongoDB for running integration tests with Spring Data MongoDB.

## <a name="a-10-17"></a>10.17 @WebMVCTest
The `@WebMVCTest` will bring up a mock servlet context for testing the MVC layer. Services and components are not loaded into the context. To provide these dependencies for testing, the `@MockBean` annotation is typically used.

## <a name="a-10-18"></a>10.18 @AutoConfigureMockMVC
The `@AutoConfigureMockMVC` annotation works very similarly to the `@WebMVCTest` annotation, but the full Spring Boot context is started.

## <a name="a-10-19"></a>10.19 @MockBean
Creates and injects a Mockito Mock for the given dependency.

## <a name="a-10-20"></a>10.20 @JsonTest
Will limit the auto-configuration of Spring Boot to components relevant to processing JSON.

This annotation will also autoconfigure an instance of JacksonTester or GsonTester.

## <a name="a-10-21"></a>10.21 @TestPropertySource
Class level annotation used to specify property sources for the test class.