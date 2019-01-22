package br.com.bigwolf.resource.rest;


import br.com.bigwolf.domain.Tarefa;
import br.com.bigwolf.service.TarefaService;
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
        value = "/tarefas",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class TarefaRestController {

    @Autowired
    private TarefaService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") int id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tarefa getTarefa(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tarefa editar(@PathVariable("id") int id, @RequestBody Tarefa tarefa){
        service.update(id, tarefa);
        return tarefa;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Tarefa tarefa){
        service.save(tarefa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tarefa.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tarefa> listar(){
        return service.findAll();
    }

}
