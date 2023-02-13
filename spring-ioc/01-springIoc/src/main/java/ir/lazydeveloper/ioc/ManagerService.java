package ir.lazydeveloper.ioc;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    public ManagerService() {
        System.out.println("Manager service constructor called...");
    }
}
