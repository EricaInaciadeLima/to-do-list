package com.api.to_do_list.service;

import com.api.to_do_list.model.StatusTipo;
import com.api.to_do_list.model.Tarefa;
import com.api.to_do_list.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(@Valid Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> buscarPorStatus(StatusTipo status) {
        return tarefaRepository.findByStatus(status);
    }

    public List<Tarefa> buscarTodos() {
        return tarefaRepository.findAll();
    }

    public Tarefa atualizarTarefa(Long id, @Valid Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID " + id + " não encontrada."));

        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setStatus(tarefaAtualizada.getStatus());

        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return  tarefaRepository.existsById(id);
    }
}
