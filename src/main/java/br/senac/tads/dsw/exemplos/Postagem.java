package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// POJO - Plain Old Java Object
public class Postagem {
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private LocalDateTime dataAtual;
    @NotBlank
    @Size(min = 10)
    private String postagem;
    @NotBlank
    private boolean ehPostado;

    public Postagem(String titulo, String autor, LocalDateTime dataAtual, String postagem, boolean ehPostado) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataAtual = dataAtual;
        this.postagem = postagem;
        this.ehPostado = ehPostado;
    }

    public boolean isEhPostado() {
        return ehPostado;
    }

    public void setEhPostado(boolean ehPostado) {
        this.ehPostado = ehPostado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDateTime dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }
}