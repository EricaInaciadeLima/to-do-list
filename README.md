# To-Do List API

API RESTful para gerenciamento de tarefas (To-Do List), desenvolvida com **Spring Boot**, seguindo boas práticas de mercado como discovery técnico, modelagem de dados, separação de responsabilidades e organização por ambientes.

Este projeto tem como objetivo **estudo e simulação de um fluxo real de desenvolvimento backend**.

---

## 📌 Sumário
- [Objetivo do Projeto](#objetivo-do-projeto)
- [Escopo Funcional](#escopo-funcional)
- [Discovery Técnico](#discovery-técnico)
- [Modelagem de Dados](#modelagem-de-dados)
- [Status da Tarefa](#status-da-tarefa)
- [Métodos HTTP e Endpoints](#métodos-http-e-endpoints)
- [Regras de Negócio](#regras-de-negócio)
- [Ambientes](#ambientes)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

---

## 🎯 Objetivo do Projeto
Desenvolver uma **API RESTful de lista de tarefas**, aplicando conceitos fundamentais de backend como:
- Versionamento com Git
- Organização de ambientes
- Modelagem correta de banco de dados
- Regras de negócio bem definidas
- APIs REST

---

## 📋 Escopo Funcional
A aplicação permite que um usuário:
- Cadastre tarefas
- Liste tarefas
- Atualize o status de uma tarefa
- Exclua tarefas

Não há frontend. A API é testada utilizando clientes HTTP como **Insomnia** ou **Bruno**.

---

## 🔍 Discovery Técnico
Antes da implementação, foi realizado um **processo de discovery**, onde foram definidas:
- Entidades do sistema
- Estrutura do banco de dados
- Métodos HTTP
- Regras de negócio
- Estratégia de ambientes

📄 Para mais detalhes, consulte o documento:
➡️ **[Discovery – Projeto To-Do List](./DISCOVERY.md)**

---

## 🗄️ Modelagem de Dados
O sistema utiliza **uma entidade principal**, representando as tarefas.

### Entidade: Task
Campos principais:
- `id`
- `title`
- `description`
- `status`
- `created_at`
- `updated_at`

As datas de criação e atualização são **metadados técnicos**, controlados automaticamente pelo sistema.

---

## 🔄 Status da Tarefa
Os status são definidos no código por meio de um `enum`, como:
- `PENDING`
- `IN_PROGRESS`
- `DONE`

O banco de dados armazena o status como `VARCHAR`, garantindo flexibilidade futura.

---

## 🌐 Métodos HTTP e Endpoints
A API utiliza os seguintes métodos:

- **GET** → Listar tarefas (com filtro por status)
- **POST** → Criar tarefa
- **PUT** → Atualizar tarefa / status
- **DELETE** → Excluir tarefa

As regras completas de cada endpoint estão descritas no documento de discovery.

---

## 📐 Regras de Negócio
- O status é obrigatório na criação da tarefa
- O cliente informa apenas dados de negócio
- Datas de criação e atualização são geradas automaticamente
- Toda atualização altera o campo `updated_at`
- O sistema garante consistência dos dados

---

## 🌎 Ambientes
O projeto suporta múltiplos ambientes:

- `local`
- `dev`
- `hom`
- `prod`

Cada ambiente possui seu próprio arquivo:
```text
application-{profile}.properties
