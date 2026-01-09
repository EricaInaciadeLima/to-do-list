package com.api.to_do_list.controller;

import com.api.to_do_list.model.StatusTipo;
import com.api.to_do_list.model.Tarefa;
import com.api.to_do_list.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    //Injenção de dependência-> permitir que a camada de controle se comunique com a camada de serviço
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/casdastrar")
    public ResponseEntity<String> cadastrar (@RequestBody Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa cadastrada com sucesso!");
    }

    @GetMapping("/status")
    public ResponseEntity<List<Tarefa>> listarPorStatus (@RequestParam(required = false) StatusTipo status) {
        List<Tarefa> tarefas;
        if (status != null) {
            tarefas = tarefaService.buscarPorStatus(status);
        } else  {
            tarefas = tarefaService.buscarTodos();
        }
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @PathVariable Long id,
            @Valid @RequestBody Tarefa tarefaAtualizada) {

        Tarefa tarefa = tarefaService.atualizarTarefa(id, tarefaAtualizada);
        return ResponseEntity.ok(tarefa);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        boolean existe = tarefaService.existePorId(id);
        if (!existe) {
            return ResponseEntity.notFound().build(); // 404
        }

        tarefaService.deletarPorId(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
