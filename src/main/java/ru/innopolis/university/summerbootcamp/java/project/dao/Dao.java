package ru.innopolis.university.summerbootcamp.java.project.dao;

/**
 * Data Access Object
 */
public interface Dao<T> {

    void create(T t);

    void read(T t);

    void update(T t);

    void deleate(T t);



}
