package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Usuario;
import br.com.bigwolf.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements Dao<Usuario>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Usuario obj) {
        entityManager.persist(obj);
    }

    @Override
    public void update(Usuario obj) {

        entityManager.merge(obj);
    }

    @Override
    public void delete(int id) {
        try {
            entityManager.remove(entityManager.getReference(Usuario.class, id));
        }catch (EntityNotFoundException ex){
            throw new NaoExisteDaoException("Usuario não encontrado para id = " + id + ".");
        }
    }

    @Override
    public Usuario findById(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if(usuario == null){
            throw new NaoExisteDaoException("Usuario não encontrado para id = " + id + ".");
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("select u from Usuario u", Usuario.class)
                .getResultList();
    }
}
