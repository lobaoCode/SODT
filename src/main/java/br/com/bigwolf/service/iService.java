package br.com.bigwolf.service;


import java.util.List;

public interface iService<T>{

    void save(T obj);
    void update(int id, T obj);
    void delete(int id);
    T findById(int id);
    List<T> findAll();

}
