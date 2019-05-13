# Spring-Hibernate

---

## Thymeleaf

Thymeleaf is a very powerful front-end template. Like JSP. But the main difference is, Thymeleaf can be used in a web and non-web environment where instead JSP can only be used in a web environment.\
Some non-web environments can be: E-Mail templates, CSV templates or creating a PDF file.

#### 74.

In the `FirstSetup` folder is the first little setup making use of Thymeleaf. It contains everything needed for a first Thymeleaf application.\
A `DemoController` is setup do direct the URL to the right HTML file in the "resources/templates" folder. The `helloworld.html` there uses Thymeleaf to display the information given by the model from the controller.