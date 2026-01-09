# to-do-list
# Discovery – Projeto To-Do List

## 1. Objetivo do Projeto

O objetivo deste projeto é desenvolver uma **API RESTful de lista de tarefas (To-Do List)**, seguindo boas práticas utilizadas no mercado de tecnologia. O foco está em organização de código, separação de responsabilidades, versionamento com Git, definição de ambientes e modelagem correta de dados.

Este projeto é voltado para estudo e simulação de um fluxo real de desenvolvimento backend.

---

## 2. Escopo Funcional

A aplicação permitirá que um usuário:

* Cadastre tarefas
* Liste tarefas
* Atualize o status de uma tarefa
* Exclua tarefas

Não haverá frontend. A API será testada por meio de clientes HTTP como **Insomnia** ou **Bruno**.

---

## 3. Modelagem de Dados (Banco de Dados)

Após o processo de discovery, foi definido que o projeto utilizará **apenas uma entidade principal**, representando as tarefas.

### 3.1 Entidade: Task (Tarefa)

Campos definidos:

* **id**: identificador único da tarefa
* **title**: título da tarefa (obrigatório)
* **description**: descrição detalhada da tarefa (opcional)
* **status**: status atual da tarefa
* **created_at**: data e hora de criação da tarefa
* **updated_at**: data e hora da última atualização da tarefa

### 3.2 Decisões de Modelagem

* O campo **status** será armazenado como `VARCHAR` no banco de dados
* As regras de valores permitidos para status serão controladas no código por meio de um `enum`
* As datas de criação e atualização não serão informadas pelo usuário, sendo controladas automaticamente pelo sistema

Essa abordagem garante flexibilidade, segurança e aderência às boas práticas de mercado.

---

## 4. Status da Tarefa

Os possíveis status da tarefa serão definidos no código da aplicação, podendo incluir:

* PENDING (pendente)
* IN_PROGRESS (em andamento)
* DONE (concluída)

A mudança de status faz parte das regras de negócio e será tratada na camada de serviço.

---

## 5. Métodos HTTP e Endpoints

### 5.1 Métodos Utilizados

* **GET**: listar tarefas
* **POST**: criar uma nova tarefa
* **PUT**: atualizar uma tarefa existente (principalmente status)
* **DELETE**: excluir uma tarefa

### 5.2 Funcionalidades dos Endpoints

#### GET

* Listar todas as tarefas
* Filtrar tarefas por status (pendentes, em andamento, concluídas)

#### POST

* Criar uma nova tarefa
* Campos obrigatórios: título
* Campos opcionais: descrição

#### PUT

* Atualizar informações de uma tarefa
* Atualizar status
* Registrar automaticamente a data e hora da última atualização

#### DELETE

* Excluir uma tarefa pelo identificador

---

## 6. Regras de Negócio

* Ao criar uma tarefa, o **status é obrigatório** e deve ser informado pelo cliente no momento do cadastro
* O cliente informa apenas dados de negócio: título, descrição (opcional) e status
* No momento da criação da tarefa, o sistema registra automaticamente a data e hora em `created_at`
* Toda atualização realizada em uma tarefa gera automaticamente um novo registro de data e hora em `updated_at`
* O usuário não informa manualmente datas de criação ou atualização
* O status da tarefa define seu estado no fluxo
* A atualização de uma tarefa sempre gera uma nova data de atualização
* O usuário não informa datas de criação ou atualização
* O sistema registra automaticamente `created_at` e `updated_at`
* O status da tarefa define seu estado no fluxo
* A atualização de uma tarefa sempre gera uma nova data de atualização

---

## 7. Ambientes

O projeto será estruturado para suportar múltiplos ambientes:

* **local**: desenvolvimento local
* **dev**: ambiente de desenvolvimento
* **hom**: homologação
* **prod**: produção

Cada ambiente possui seu próprio arquivo de configuração (`application-{profile}.properties`).

---

## 8. Considerações Finais

Este documento representa a fase de **discovery** do projeto, onde foram definidas:

* As responsabilidades do sistema
* A modelagem do banco de dados
* Os métodos HTTP utilizados
* As regras de negócio principais

