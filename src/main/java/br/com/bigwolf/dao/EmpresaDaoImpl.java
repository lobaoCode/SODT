package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Empresa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmpresaDaoImpl implements Dao<Empresa> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Empresa obj) {
        entityManager.persist(obj);
    }

    @Override
    public void update(Empresa obj) {
        entityManager.merge(obj);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.getReference(Empresa.class, id));
    }

    @Override
    public Empresa findById(int id) {
        return entityManager.find(Empresa.class, id);
    }

    @Override
    public List<Empresa> findAll() {
        return entityManager.createQuery("select e from Empresa e", Empresa.class)
                .getResultList();
    }
}
