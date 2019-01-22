package br.com.bigwolf.service;

import br.com.bigwolf.dao.Dao;
import br.com.bigwolf.domain.Usuario;
import br.com.bigwolf.exception.IdNaoValidoServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private Dao<Usuario> dao;


    @Override
    public void save(Usuario obj) {
        dao.save(obj);
    }

    @Override
    public void update(int id, Usuario obj) {
        obj.setId(idValido(id));
        dao.findById(id);
        dao.update(obj);
    }

    @Override
    public Usuario updateSenha(int id, Usuario obj) {
        Usuario usuario = dao.findById(idValido(id));
        usuario.setSenha(obj.getSenha());
        return usuario;
    }

    @Override
    public void delete(int id) {

        dao.delete(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public Usuario findById(int id) {

        return dao.findById(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public List<Usuario> findAll() {
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
