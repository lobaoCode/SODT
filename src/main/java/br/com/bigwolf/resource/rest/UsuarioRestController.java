package br.com.bigwolf.resource.rest;

import br.com.bigwolf.domain.Usuario;
import br.com.bigwolf.service.UsuarioService;
import br.com.bigwolf.service.iService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(
        value = "/usuarios",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class UsuarioRestController {

    @Autowired
    private UsuarioService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") int id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario editar(@PathVariable("id") int id, @RequestBody Usuario usuario){
        service.update(id, usuario);
        return usuario;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario editarSenha(@PathVariable("id") int id, @RequestBody Usuario usuario){
        return service.updateSenha(id, usuario);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Usuario usuario){
        service.save(usuario);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listar(){
        return service.findAll();
    }

}
