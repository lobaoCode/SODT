package br.com.bigwolf.service;

import br.com.bigwolf.domain.Tarefa;

import java.util.List;

public interface TarefaService {
    void save(Tarefa obj);
    void update(int id, Tarefa obj);
    void delete(int id);
    Tarefa findById(int id);
    List<Tarefa> findAll();
}
