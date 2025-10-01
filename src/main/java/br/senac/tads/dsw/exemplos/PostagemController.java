package br.senac.tads.dsw.exemplos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class PostagemController {
    @Autowired
    private PostagemService service;

    @GetMapping
    public List<Postagem> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody @Valid Postagem postagem) {
        Postagem p = service.addNew(postagem);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{nomeAutor}")
                .buildAndExpand(p.getAutor())
                .toUri();   
        return ResponseEntity.created(location).build();
    }
}
