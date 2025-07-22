package org.example.fileBasedDatabase;
import java.util.List;

public interface IRepository<T>{
    void add(T entity);
    List<T> getAll();
    T getById(int id);
    void update(T entity);
    void remove(int id);


}
