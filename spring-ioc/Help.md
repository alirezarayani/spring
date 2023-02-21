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

Both BeanFactory and ApplicationContext provides a way to get a bean from Spring IOC container by calling getBean("bean
name")

---

## What is Configuration Metadata?

The Spring IoC container consumes a form of configuration metadata. This configuration metadata represents how you, as
an application developer, tell the Spring container to instantiate, configure, and assemble the objects in your
application.

> Three ways we can supply Configuration Metadata to Spring IoC container
>1. XML-based configuration
>2. Annotation-based configuration
>3. Java-based configuration

---

## How to Create a Spring Container?

Spring provides many ApplicationContext interface implementations that we use are;

1. **AnnotationConfigApplicationContext**: If we are using Spring in standalone Java applications and using annotations
   for Configuration, then we can use this to initialize the container and get the bean objects.
2. **ClassPathXmlApplicationContext**: If we have spring bean configuration XML file in a standalone application, then
   we can use this class to load the file and get the container object
3. **FileSystemXmlApplicationContext**: This is similar to ClassPathXmlApplicationContext except that the XML
   configuration file can be loaded from anywhere in the file system.
4. AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.

---

## How to Retrieve Bean from Spring Container?

```java
HelloWorld obj=(HelloWorld)context.getBean("helloWorld");
        HelloWorld helloObject=(HelloWorld)context.getBean(HelloWorld.class);
```

---

# XML-based configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--Set Property Value -->
    <bean id="manager" class="ir.lazydeveloper.Manager">
        <property name="firstName" value="Alireza"/>
    </bean>

    <!--Set Scope Type -->
    <bean id="manager1" class="ir.lazydeveloper.Manager" scope="prototype"/>

    <!--Set Constructor Value -->
    <bean id="manager" class="ir.lazydeveloper.session01.Manager">
        <constructor-arg name="name" value="Alireza"/>
    </bean>
    <bean id="manager1" class="ir.lazydeveloper.session01.Manager">
        <constructor-arg index="0" value="Ahamad"/>
    </bean>


    <bean id="managerService" class="ir.lazydeveloper.session01.ManagerService">
        <property name="mailService" ref="yahooService"/>
    </bean>

    <bean id="yahooService" class="ir.lazydeveloper.session01.MailService"/>
</beans>
```

---

## Factory Design Pattern Useing Spring

```xaml
  <bean id="managerService" factory-bean="factory" factory-method="getManagerService">
        <property name="mailService" ref="emailService"/>
    </bean>
    <bean id="factory" class="ir.lazydeveloper.session01.bahador.ManagerServiceFactory"/>
    <bean id="emailService" class="ir.lazydeveloper.session01.MailService"/>
   ```

   ```java
   public class ManagerServiceFactory {
    public ManagerService getManagerService() {
        ManagerService managerService = new ManagerService();
        return managerService;
    }
}
   ```

---

## Setter XML Injection

```xml

<bean id="managerService" class="ir.lazydeveloper.service.ManagerService">
    <property name="mailService" ref="yahooService"/>
</bean>

<bean id="yahooService" class="ir.lazydeveloper.service.MailService"/>
```

## Constructor XML Injection

```xml

<bean id="notificationService" class="com.nikamooz.spring.service.NotificationService">
    <constructor-arg ref="notifier"/>
</bean>
<bean id="notifier" class="com.nikamooz.spring.service.Notifier"/>
```

The @Autowired annotation is used in Constructor injection, Setter injection, and Field injection.

The @Qualifier annotation is used in conjunction with @Autowired to avoid confusion when we have two or more beans
configured for the same type.

---

## @DependsOn Annotation

The @DependsOn annotation can force the Spring IoC container to initialize one or more beans before the bean which is
annotated by @DependsOn annotation.

```java

@Configuration
public class AppConfig {

    @Bean("firstBean")
    @DependsOn(value = {
            "secondBean",
            "thirdBean"
    })
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean("secondBean")
    public SecondBean secondBean() {
        return new SecondBean();
    }

    @Bean("thirdBean")
    public ThirdBean thirdBean() {
        return new ThirdBean();
    }
}

```

---

## Bean Scope

1. Singleton
2. Prototype
3. Request
4. Session
5. Application
6. Websocket

---

| Scope    |   Scope    |  Result |
|----------|:----------:|--------:|
| Singlton |  Singlton  |   OK    |
| Prtotype |  Prtotype  |   OK    |
| Prtotype |  Singlton  |   OK    |
| Singlton |  Prtotype  |   NO    |

---

> As a rule, use the prototype scope for all stateful beans and the singleton scope for stateless beans.

```xml

<bean id="yahooService" class="ir.lazydeveloper.service.MailService" scope="singleton"/>
```

#### Singleton

```java

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("singleton") // default scope 
    public MailService mailService() {
        return new MailService();
    }
}
```

#### Prototype

```xml

<bean id="yahooService" class="ir.lazydeveloper.service.MailService" scope="prototype"/>
```

```java

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public UserService userService() {
        return new UserService();
    }
}
```

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean

---

## Spring Lifecycle

> InitializingBean and DisposableBean
>
In Spring, to interact with the container’s management of the bean lifecycle, you can implement the Spring
InitializingBean and DisposableBean interfaces. The container calls afterPropertiesSet() for the former and destroy()
for the latter to let the bean perform certain actions upon initialization and destruction of your beans.

The JSR-250 @PostConstruct and @PreDestroy annotations are generally considered best practice for receiving lifecycle
callbacks in a modern Spring application. Using these annotations means that your beans are not coupled to
Spring-specific interfaces.

1. For bean implemented InitializingBean, it will run afterPropertiesSet() after all bean properties have been set.
2. For bean implemented DisposableBean, it will run destroy() after Spring container is released the bean.

> @PostConstruct and @PreDestroy

Note that the @PostConstruct and @PreDestroy annotation does not belong to Spring, it’s located in the J2ee library –
common-annotations.jar.

Note that both the @PostConstruct and @PreDestroy annotations are part of Java EE. Since Java EE was deprecated in Java
9, and removed in Java 11, we have to add an additional dependency to use these annotations:

```xml

<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

```xml

<bean id="yahooService" class="ir.lazydeveloper.service.MailService"
      init-method="init" destroy-method="destroy">
</bean>

```

```java

@Configuration
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DatabaseInitiaizer databaseInitiaizer() {
        return new DatabaseInitiaizer();
    }
}
```

---
> @Resource Spring also supports injection using the JSR-250 @Resource annotation on fields or bean property setter methods

> @Primary  Use @Primary to give higher preference to a bean when there are multiple beans of the same type.

---

### How to enable annotation-based wiring?

Annotation wiring is not turned on in the Spring container by default. So, before we can use annotation-based wiring, we
will need to enable it in our Spring configuration file. So consider the following configuration file in case you want
to use any annotation in your Spring application.

```xml
<?xml version = "1.0" encoding = "UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xmlns:context = "http://www.springframework.org/schema/context"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">

   <context:annotation-config/>
   <!-- bean definitions go here -->

</beans>
```
