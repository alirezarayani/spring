package ir.lazydeveloper;

import ir.lazydeveloper.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerService managerService = context.getBean("managerService", ManagerService.class);
        managerService.sendEmail();
        System.out.println("-------------");
        managerService.sendEmailEffectedByAround();
        System.out.println("-------------");
        managerService.sendEmailWithException();

        System.out.println(managerService);
    }
}

