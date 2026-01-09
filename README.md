# 📝 To-Do List API

API RESTful para gerenciamento de tarefas, desenvolvida com foco em boas práticas de backend.

---

## 📌 Sumário
- 🎯 [Objetivo do Projeto](#objetivo-do-projeto)
- 📋 [Escopo Funcional](#escopo-funcional)
- 🗄️ [Modelagem de Dados](#modelagem-de-dados-banco-de-dados)
- 🔄 [Status da Tarefa](#status-da-tarefa)
- 🌐 [Métodos HTTP e Endpoints](#métodos-http-e-endpoints)
- 📐 [Regras de Negócio](#regras-de-negócio)
- 🌎 [Ambientes](#ambientes)
- 📌 [Considerações Finais](#considerações-finais)

---

## 🎯 Objetivo do Projeto
O objetivo deste projeto é desenvolver uma **API RESTful de lista de tarefas (To-Do List)**, seguindo boas práticas utilizadas no mercado de tecnologia. O foco está em organização de código, separação de responsabilidades, versionamento com Git, definição de ambientes e modelagem correta de dados.

Este projeto é voltado para estudo e simulação de um fluxo real de desenvolvimento backend.

---

## 📋 Escopo Funcional
A aplicação permitirá que um usuário:
- ➕ Cadastre tarefas
- 📄 Liste tarefas
- 🔁 Atualize o status de uma tarefa
- ❌ Exclua tarefas

---

## 🗄️ Modelagem de Dados (Banco de Dados)
Após o processo de discovery, foi definido que o projeto utilizará **apenas uma entidade principal**, representando as tarefas.

### 📌 Entidade: Tarefa
Campos definidos:
- **id**: identificador único da tarefa
- **titulo**: título da tarefa (obrigatório)
- **descricao**: descrição detalhada da tarefa (opcional)
- **status**: status atual da tarefa
- **criacao_em**: data e hora de criação da tarefa
- **atualizacao_em**: data e hora da última atualização da tarefa

### ⚙️ Decisões de Modelagem
- O campo **status** será armazenado como `VARCHAR`
- Os valores permitidos serão controlados via `enum` no código
- Datas são **metadados técnicos**, controlados pelo sistema

---

## 🔄 Status da Tarefa
Os possíveis status incluem:
- 🕒 Pendente
- 🚧 Em progresso
- ✅ Concluída

A mudança de status faz parte das regras de negócio.

---

## 🌐 Métodos HTTP e Endpoints
### Métodos Utilizados
- **GET** → 📄 Listar tarefas
- **POST** → ➕ Criar tarefa
- **PUT** → 🔁 Atualizar tarefa
- **DELETE** → ❌ Excluir tarefa

---

## 📐 Regras de Negócio
- ✔️ Status é obrigatório na criação
- 🚫 Usuário não informa datas
- ⏱️ Sistema registra `criacao_em` e `atualizacao_em`
- 🔄 Toda atualização altera `atualizacao_em`

---

## 🌎 Ambientes
- 🖥️ **local**
- 🧪 **dev**
- 🧩 **hom**
- 🚀 **prod**

Cada ambiente possui seu próprio `application-{profile}.properties`.

---

## 📌 Considerações Finais
Este documento representa a fase de **discovery**, servindo como base para a implementação da API e garantindo um desenvolvimento organizado e alinhado às boas práticas do mercado.
