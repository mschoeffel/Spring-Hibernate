# Spring-Hibernate

---

## Bean Hooks / Bean Lifecycle

The lifecycle of a bean can be modified by adding two attributes: "init-method" and "destroy-method" to the bean config in the beanHooks-applicationContext.xml.

The init-method attribute defines what method to call when the bean gets instantiated .
The destroy-method attribute defines what method to call before the bean gets deleted.

Caution: with prototype beans the delete-method won't be called!

---

In this example the bean outputs "Object ini successful" after it's instantiated and "Object is closed successfully" before the bean gets deleted.
