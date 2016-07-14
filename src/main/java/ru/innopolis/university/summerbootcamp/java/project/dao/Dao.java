package ru.innopolis.university.summerbootcamp.java.project.dao;

/**
 * Data Access Object
 */
public interface Dao<T> {

    T findByid(long id);

    void insert(T t);

    void delete(T t);

}
