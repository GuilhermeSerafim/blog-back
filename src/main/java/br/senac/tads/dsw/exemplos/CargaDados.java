package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDados {

    @Bean
    public CommandLineRunner executar(PostagemRepository repository) {
        return args -> {
            Postagem p1 = new Postagem("Como viver bem", "Fulano da Silva", LocalDate.of(2025, 10, 31), "Veja neste texto dicas de como viver bem a vida.");
            Postagem p2 = new Postagem("20 Dicas para falar bem", "Ciclano de Souza", LocalDate.of(2025, 12, 2), "Aqui estão 20 dicas para você falar melhor em público.");
            
            repository.saveAll(Arrays.asList(p1, p2));
        };
    }
}