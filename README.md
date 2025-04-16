### 📚 Projeto Clean Architecture - Gerenciamento de Livros

Este projeto foi desenvolvido como parte do curso Arquitetura Java: descomplicando a Clean Architecture da Alura, no qual obtive certificação. O objetivo é aplicar os princípios da Clean Architecture utilizando o ecossistema do Spring Boot, simulando um sistema de gerenciamento de livros com operações de criação, listagem, atualização e deleção de registros.

### 🛡️ Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

JPA (com Repositórios)

Arquitetura Limpa (Camadas: Domain, Application, Infra)

JUnit 5

Mockito

### 📂 Estrutura de Pastas

├── domain
<br>
│   ├── entitiys
<br>
│   │   ├── livros
<br>
│   │   └── records
<br>
├── application
<br>
│   ├── usecases
<br>
│   └── gateways
<br>
├── infra
<br>
│   ├── controller
<br>
│   ├── gateways
<br>
│   └── persistance
<br>
└── config

## ✅ End-Points

### 🔹 Cadastro de Livros

Permite cadastrar novos livros fornecendo:

<br>

![Image](https://github.com/user-attachments/assets/095fd457-94d1-4d99-bb1f-bba566a0bcc2)
<br>

### 🔹 Listagem de Livros

Retorna todos os livros cadastrados no sistema.

<br>

![Image](https://github.com/user-attachments/assets/259d9407-717f-4991-bbc8-b31c46aabaac)
<br>

### 🔹 Atualização de Livros

Atualiza os dados de um livro com base no título.

<br>

![Image](https://github.com/user-attachments/assets/8fe956d0-75f2-482e-b3e6-c05cbbc87d95)
<br>

### 🔹 Deleção de Livros

Deleta um livro com base no título.

<br>

![Image](https://github.com/user-attachments/assets/5ae7293d-caf0-4e1e-abd8-3a9a6b49c008)
<br>

