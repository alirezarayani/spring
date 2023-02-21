package ir.lazydeveloper;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        ManagerService managerService = factory.getBean("proxy", ManagerService.class);
        managerService.sendEmail();
    }

}

