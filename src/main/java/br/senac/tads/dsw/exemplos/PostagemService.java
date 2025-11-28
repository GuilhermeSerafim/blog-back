package br.senac.tads.dsw.exemplos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository repository;

    public List<Postagem> findAll() {
        return repository.findAll();
    }

    public Optional<Postagem> findById(Long id) {
        return repository.findById(id);
    }

    public Postagem save(Postagem postagem) {
        return repository.save(postagem);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}