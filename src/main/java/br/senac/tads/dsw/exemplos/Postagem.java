package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// POJO - Plain Old Java Object
public class Postagem {
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    @Size(min = 10)
    private String postagem;
    @NotNull
    private LocalDateTime dataAtual;

    public Postagem(String titulo, String autor, LocalDateTime dataAtual, String postagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataAtual = dataAtual;
        this.postagem = postagem;
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