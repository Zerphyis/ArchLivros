📚 Projeto Clean Architecture - Gerenciamento de Livros

Este projeto foi desenvolvido como parte do curso Arquitetura Java: descomplicando a Clean Architecture da Alura, no qual obtive certificação. O objetivo é aplicar os princípios da Clean Architecture utilizando o ecossistema do Spring Boot, simulando um sistema de gerenciamento de livros com operações de criação, listagem, atualização e deleção de registros.

🛡️ Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

JPA (com Repositórios)

Arquitetura Limpa (Camadas: Domain, Application, Infra)

JUnit 5

Mockito

📂 Estrutura de Pastas

├── domain
│   ├── entitiys
│   │   ├── livros
│   │   └── records
├── application
│   ├── usecases
│   └── gateways
├── infra
│   ├── controller
│   ├── gateways
│   └── persistance
└── config
