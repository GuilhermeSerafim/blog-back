package br.senac.tads.dsw.exemplos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/postagens")
@CrossOrigin(origins = "*")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @GetMapping
    public List<Postagem> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Postagem addNew(@RequestBody @Valid Postagem postagem) {
        return service.save(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> update(@PathVariable Long id, @RequestBody @Valid Postagem postagemAtualizada) {
        return service.findById(id)
                .map(postagem -> {
                    postagem.setTitulo(postagemAtualizada.getTitulo());
                    postagem.setAutor(postagemAtualizada.getAutor());
                    postagem.setDataPublicacao(postagemAtualizada.getDataPublicacao());
                    postagem.setTexto(postagemAtualizada.getTexto());
                    return ResponseEntity.ok(service.save(postagem));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}