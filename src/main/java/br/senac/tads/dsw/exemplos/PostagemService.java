package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    private Map<String, Postagem> mapPostagem;

    public PostagemService() {
        mapPostagem = new HashMap<>();
        mapPostagem.put("Guilherme", new Postagem("Primeira Postagem", "Guilherme", LocalDateTime.now(),
                "Conteúdo da primeira postagem", true));
        mapPostagem.put("Maria",
                new Postagem("Segunda Postagem", "Maria", LocalDateTime.now(), "Conteúdo da segunda postagem", false));
        mapPostagem.put("João",
                new Postagem("Terceira Postagem", "João", LocalDateTime.now(), "Conteúdo da terceira postagem", true));
    }

    public List<Postagem> findAll() {
        List<Postagem> postagens = new ArrayList<>(mapPostagem.values());
        return postagens;
    }

    public Postagem addNew(Postagem postagem) {
        if (postagem.getDataAtual() != null && postagem.getDataAtual().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data da postagem não pode ser no futuro.");
        }
        if (postagem.getPostagem().length() < 10) {
            throw new IllegalArgumentException("A postagem deve ter no mínimo 10 caracteres.");
        }
        mapPostagem.put(postagem.getAutor(), postagem);
        return postagem;
    }

}
