package ru.innopolis.university.summerbootcamp.java.project.repository;


import java.util.List;

/**
 * Data Access Object
 */
public interface Repository<T> {

    void create(T t);

    T read(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();

}
