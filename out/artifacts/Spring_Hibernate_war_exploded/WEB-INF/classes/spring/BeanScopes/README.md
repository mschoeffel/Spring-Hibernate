# Spring-Hibernate

---

## Bean Scopes

Bean scopes describe how often an object can be created and instantiated.

By default if you don't add a scope attribute to the bean it's Singleton. So every instance of this bean refers to the exact same object.

You can add one of the following scopes to modify this behaviour:

|Scope|Description|
|---|---|
| singleton (default) | Create a single shared instance of the bean (default) |
| prototype | Creates a new bean instance for each container request |
| request | Scoped to an HTTP web request. Only used for web apps. |
| session | Scoped to an HTTP web session. Only used for web apps. |
| global-session| Scoped to a global HTTP web session. Only used for web apps. |


---

In this example there are two different beans instantiated. Each two times and compared. One of them got the scope=prototype the other stays default.
