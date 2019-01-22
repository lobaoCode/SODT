package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Tarefa;
import br.com.bigwolf.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class TarefaDaoImpl implements Dao<Tarefa> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Tarefa obj) {
        entityManager.persist(obj);
    }

    @Override
    public void update(Tarefa obj) {
        entityManager.merge(obj);
    }

    @Override
    public void delete(int id) {

        try {
            entityManager.remove(entityManager.getReference(Tarefa.class, id));
        }catch (EntityNotFoundException ex){
            throw new NaoExisteDaoException("Tarefa não encontrada para id = " + id + ".");
        }
    }

    @Override
    public Tarefa findById(int id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        if(tarefa == null){
            throw new NaoExisteDaoException("Tarefa não encontrada para id = " + id + ".");
        }
        return tarefa;
    }

    @Override
    public List<Tarefa> findAll() {
        return entityManager.createQuery("select t from Tarefa t", Tarefa.class)
                .getResultList();
    }
}
