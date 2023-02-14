# Spring IOC container

## What is the Spring Container?

The Spring container is responsible for instantiating, configuring, and assembling the Spring beans. The container gets
its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. The
configuration metadata is represented in XML, Java annotations, or Java code. It lets you express the objects that
compose your application and the rich inter-dependencies between those objects.

**The responsibilities of IOC container are:**

* Instantiating the bean
* Wiring the beans together
* Configuring the beans
* Managing the bean’s entire life-cycle

The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC
container. Spring framework provides two distinct types of containers.

1. BeanFactory container
2. ApplicationContext container

BeanFactory is the root interface of Spring IOC container. ApplicationContext is the child interface of BeanFactory
interface that provides Spring AOP features, i18n etc.

One main difference between BeanFactory and ApplicationContext is that BeanFactory only instantiates bean when we call
getBean() method while ApplicationContext instantiates singleton bean when the container is started, It doesn't wait for
getBean() method to be called.

---

## What is Configuration Metadata?

The Spring IoC container consumes a form of configuration metadata. This configuration metadata
represents how you, as an application developer, tell the Spring container to instantiate, configure, and assemble the
objects in your application.

> Three ways we can supply Configuration Metadata to Spring IoC container
>1. XML-based configuration
>2. Annotation-based configuration
>3. Java-based configuration

---

## How to Create a Spring Container?

Spring provides many ApplicationContext interface implementations that we use are;

1. **AnnotationConfigApplicationContext**: If we are using Spring in standalone Java applications and using annotations for
   Configuration, then we can use this to initialize the container and get the bean objects.
2. **ClassPathXmlApplicationContext**: If we have spring bean configuration XML file in a standalone application, then we
   can use this class to load the file and get the container object
3. **FileSystemXmlApplicationContext**: This is similar to ClassPathXmlApplicationContext except that the XML configuration
   file can be loaded from anywhere in the file system.
4. AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
---
## How to Retrieve Bean from Spring Container?
```java
HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
HelloWorld helloObject = (HelloWorld) context.getBean(HelloWorld.class);
```
