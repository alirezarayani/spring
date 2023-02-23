package ir.lazydeveloper.repository;

import java.util.List;

public interface CrudRepository<T> {

    public void save(T t);

    public void update(T t);

    public void remove(T t);

    public void getByName(T t);

    public void getByID(Long id);

    public List<T> findAll();
}
