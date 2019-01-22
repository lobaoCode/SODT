package br.com.bigwolf.resource.rest;


import br.com.bigwolf.domain.Empresa;
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
        value = "/empresas",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class EmpresaRestController {

    @Autowired
     private iService<Empresa> service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Empresa> listar(){
        return service.findAll();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Empresa empresa){
        service.save(empresa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(empresa.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") int id){
        service.delete(id);
    }

}
