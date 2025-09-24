---

# API de Simulação de Crédito

## Descrição

Este projeto consiste em um microserviço de simulação de crédito, desenvolvido em Spring Boot, que permite cadastrar produtos de crédito e realizar simulações financeiras com base no valor solicitado e no número de meses.

O projeto segue arquitetura de microserviços, com endpoints RESTful e comunicação entre serviços via OpenFeign. A documentação é feita com Swagger/OpenAPI.


---

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- OpenFeign
- Bean Validation (Jakarta Validation)
- Swagger/OpenAPI
- Banco de dados H2
- Maven

---

## Funcionalidades

1. Cadastro de produtos de crédito (`POST /produto-credito/cadastrar`)
2. Busca de produtos por filtro (`POST /produto-credito/buscarPorFiltro`)
3. Simulação de crédito (`POST /simulacao-credito/simular`)

---

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/repositorio
```

2. Entre na pasta do projeto:

```bash
cd repositorio
```

3. Compile e execute o projeto:

```bash
mvn spring-boot:run
```

4. Acesse o Swagger UI para testar os endpoints:

```
http://localhost:8080/swagger-ui.html
```

> Observação: caso utilize dois microserviços, inicie Produto de Crédito e Simulação de Crédito em portas diferentes (ex.: 8080 e 8081).

---
