package ir.lazydeveloper.contorller;

import ir.lazydeveloper.common.MyAnnotation;
import ir.lazydeveloper.entity.Person;
import ir.lazydeveloper.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService PersonService;

    @MyAnnotation
    public void save(Person person) throws Exception{
        System.out.println("Invoked save method in controller layer");
    }

    public void update(Person person) {
        System.out.println("Invoked update method in controller layer");
    }

    public void remove(Person person) {
        System.out.println("Invoked remove method in controller layer");
    }

    public void getByName(Person person) {
        System.out.println("Invoked getByName method in controller layer");
    }

    public void getByID(Long id) {
        System.out.println("Invoked getById method in controller layer");
    }

    public List<Person> findAll() {
        System.out.println("Invoked findAll method in controller layer");
        return new ArrayList<>();
    }


}
