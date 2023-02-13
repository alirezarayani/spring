package ir.lazydeveloper.ioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        //First way :XML-based configuration
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerService managerService1 = (ManagerService) classPathXmlApplicationContext.getBean("managerService");
        ManagerService managerService2 = classPathXmlApplicationContext.getBean(ManagerService.class);

        /*
        //Second way:Java-based configuration
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ManagerService managerService3 = (ManagerService) annotationConfigApplicationContext.getBean("managerService");
        ManagerService managerService4 = annotationConfigApplicationContext.getBean(ManagerService.class);
        */

        /*
        //Second way:XML-based configuration
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("c:\\applicationContext.xml");
        ManagerService managerService5 = (ManagerService) fileSystemXmlApplicationContext.getBean("managerService");
        ManagerService managerService6 = fileSystemXmlApplicationContext.getBean(ManagerService.class);
        */

        /*
        XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("applicationContext.xml"));
        ManagerService managerService7 = factory.getBean(ManagerService.class);
        */
    }
}
