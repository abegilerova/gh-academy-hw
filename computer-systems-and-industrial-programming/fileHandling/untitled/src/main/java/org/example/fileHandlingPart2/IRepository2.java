package org.example.fileHandlingPart2;

import java.util.List;

public interface IRepository2<T> {
    List<T> getAll();
    T getById(int id);
    void add(T t);
    void update(T t);
    void remove(int id);

}
