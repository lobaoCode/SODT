package br.com.bigwolf.service;

import br.com.bigwolf.dao.Dao;
import br.com.bigwolf.domain.Tarefa;
import br.com.bigwolf.exception.IdNaoValidoServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TarefaServiceImpl implements TarefaService{

    @Autowired
    private Dao<Tarefa> dao;

    @Override
    public void save(Tarefa obj) {
        dao.save(obj);
    }

    @Override
    public void update(int id, Tarefa obj) {
        obj.setId(idValido(id));
        dao.findById(id);
        dao.update(obj);
    }

    @Override
    public void delete(int id) {
        dao.delete(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public Tarefa findById(int id) {
        return dao.findById(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public List<Tarefa> findAll() {
        return dao.findAll();
    }

    private int idValido(int id){
        if(id<=0){
            throw new IdNaoValidoServiceException("Valor do campo id está invalido. " +
                    "Deve ser maior que zero!");
        }
        return id;
    }
}
