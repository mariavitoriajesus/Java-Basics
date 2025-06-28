package org.example.kanban.repository;

import org.example.kanban.Model.StatusTarefa;
import org.example.kanban.Model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private Integer proximoId = 1;

    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }

    public List<Tarefa> listarPorEstatus(StatusTarefa status) {
        return tarefas.stream()
                .filter(t -> t.getStatus() == status)
                .toList();
    }
    public Optional<Tarefa> buscarPorId(Integer id) {
        return tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
    public Tarefa salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefa.setId(proximoId++);
            tarefas.add(tarefa);
            return tarefa;
        } else {
            return atualizar(tarefa);
        }
    }
    private Tarefa atualizar(Tarefa tarefa) {
        tarefas.replaceAll(t -> t.getId().equals(tarefa.getId()) ? tarefa : t);
        return tarefa;
    }
    public void remover(Integer id){
        tarefas.removeIf(t -> t.getId().equals(id));
    }
}
