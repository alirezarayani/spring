package ir.lazydeveloper.repository;

import ir.lazydeveloper.common.MyAnnotation;
import ir.lazydeveloper.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    public void persist(Person person) {
        System.out.println("person insert in repository layer");
    }

    @MyAnnotation
    public void update(Person person) {
        System.out.println("person update in repository layer");
    }

    public void delete(Person person) {
        System.out.println("person delete in repository layer");
    }

    public void getByName(Person person) {
        System.out.println("person getByName in repository layer");
    }

    public void getByID(Long id) {
        System.out.println("person getById in repository layer");
    }

    public List<Person> getAll() {
        System.out.println("GetAll person in repository layer");
        return new ArrayList<>();
    }
}
