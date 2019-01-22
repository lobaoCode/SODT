package br.com.bigwolf.service;

import br.com.bigwolf.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    void save(Usuario obj);
    void update(int id, Usuario obj);
    void delete(int id);
    Usuario findById(int id);
    List<Usuario> findAll();
    Usuario updateSenha(int id, Usuario ojb);
}
