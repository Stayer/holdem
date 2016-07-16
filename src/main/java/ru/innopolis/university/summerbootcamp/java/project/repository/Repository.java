package ru.innopolis.university.summerbootcamp.java.project.repository;


/**
 * Data Access Object
 */
public interface Repository<T> {

    void create(T t);

    T read(T t);

    void update(T t);

    void delete(T t);



}
