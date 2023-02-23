package ir.lazydeveloper;

import ir.lazydeveloper.common.AppConfig;
import ir.lazydeveloper.contorller.PersonController;
import ir.lazydeveloper.entity.Car;
import ir.lazydeveloper.entity.Person;
import ir.lazydeveloper.repository.CarRepository;
import ir.lazydeveloper.repository.PersonRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //Call Controller
        PersonController personController = context.getBean(PersonController.class);
        Person person = new Person();
        personController.save(person);

        System.out.println("\n\t---------------------Repository Layer----------------\n");

        //Invoke Repository layer methods
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        personRepository.update(person);
        System.out.println("\n\t-------------------------------------------------\n");
        personRepository.persist(person);

        System.out.println("\n\t-----------------Car Repository-----------------------\n");
        CarRepository carRepository = context.getBean(CarRepository.class);
        carRepository.persist(new Car());
        System.out.println("\n\t-------------------------------------------------------\n");
        carRepository.update(new Car());

    }
}
