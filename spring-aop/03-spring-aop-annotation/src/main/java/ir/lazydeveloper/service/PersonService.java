package ir.lazydeveloper.service;

import ir.lazydeveloper.entity.Person;
import ir.lazydeveloper.repository.CrudRepository;
import ir.lazydeveloper.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements CrudRepository<Person> {

    @Autowired
    private PersonRepository personRepository;

    public void save(Person person) {
        System.out.println("Invoked save method in service layer");
    }

    public void update(Person person) {
        System.out.println("Invoked update method in service layer");
    }

    public void remove(Person person) {
        System.out.println("Invoked remove method in service layer");
    }

    public void getByName(Person person) {
        System.out.println("Invoked getByName method in service layer");
    }

    public void getByID(Long id) {
        System.out.println("Invoked getByID method in service layer");
    }

    public List<Person> findAll() {
        System.out.println("Invoked findAll method in service layer");
        return new ArrayList<>();
    }
}
