package ru.innopolis.university.summerbootcamp.java.project.services;

import java.util.List;


public interface Service<T> {
    T save(T object);

    T findOne(String name);

    List<T> findAll();

    T update(T object);

    void delete(Long objectId);
}
