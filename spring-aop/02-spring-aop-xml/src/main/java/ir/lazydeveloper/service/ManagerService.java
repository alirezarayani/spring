package ir.lazydeveloper.service;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    public void sendEmail() {
        System.out.println("Send Email");
    }

    public void sendEmailWithException() {
        System.out.println("Send Email with exception");
        throw new RuntimeException();
    }

    public void sendEmailEffectedByAround() {
        System.out.println("Send Email Effected By Around");
    }
}
