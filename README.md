# Blog — API do desafio Senac

Backend do desafio de desenvolvimento web do Centro Universitário Senac. A API expõe operações sobre postagens.

## Estrutura

- Java 21 e Spring Boot 3.5.6 no `pom.xml`.
- Spring Web, Validation, Data JPA, H2 e Springdoc no manifesto.
- `PostagemController` expõe GET e POST em `/api/postagens`, além de GET, PUT e DELETE em `/api/postagens/{id}`.
- A atualização considera título, autor, data de publicação e texto.
- `application.properties` configura H2 em memória (`blogdb`), console em `/h2-console` e atualização do esquema JPA. Dados dessa configuração não devem ser tratados como armazenamento durável.

## Desenvolvimento local

Com JDK 21 e acesso às dependências Maven, use o wrapper presente na raiz:

```bash
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`. O frontend [blog-front](https://github.com/GuilhermeSerafim/blog-front) aponta para `http://localhost:8080/api/postagens`; ajuste os ambientes em conjunto se mudar o endereço.

## Limites

O controlador permite CORS de qualquer origem. A configuração H2 mantém os dados em memória; eles não persistem entre reinicializações.
