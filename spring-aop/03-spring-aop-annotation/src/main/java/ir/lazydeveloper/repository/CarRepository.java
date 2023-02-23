package ir.lazydeveloper.repository;

import ir.lazydeveloper.common.MyAnnotation;
import ir.lazydeveloper.entity.Car;
import ir.lazydeveloper.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@MyAnnotation
public class CarRepository {

    public void persist(Car person) {
        System.out.println("Car insert in repository layer");
    }

    @MyAnnotation
    public void update(Car Car) {
        System.out.println("Car update in repository layer");
    }

    public void delete(Car Car) {
        System.out.println("Car delete in repository layer");
    }

    public void getByName(Car Car) {
        System.out.println("Car getByName in repository layer");
    }

    public void getByID(Long id) {
        System.out.println("Car getById in repository layer");
    }

    public List<Car> getAll() {
        System.out.println("GetAll Car in repository layer");
        return new ArrayList<>();
    }
}
