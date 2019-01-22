package br.com.bigwolf.dao;

import java.util.List;

public interface Dao<T> {

    void save(T obj);
    void update(T obj);
    void delete(int id);
    T findById(int id);
    List<T> findAll();

}
