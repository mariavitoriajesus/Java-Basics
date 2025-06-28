package org.example.kanban.service;

import org.example.kanban.Model.StatusTarefa;
import org.example.kanban.Model.Tarefa;
import org.example.kanban.repository.TarefaRepository;

import java.util.List;

public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService() {
        this.repository = new TarefaRepository();
    }
    public Tarefa criarTabela(String titulo, String descricao, String dataVencimento) {
        Tarefa tarefa = new Tarefa(null, titulo, descricao, java.time.LocalDate.parse(dataVencimento));
        return repository.salvar(tarefa);
    }
    public List<Tarefa> listarTodasTarefas(){
        return repository.listarTodas();
    }
    public List<Tarefa> listarTarefasPorStatus(StatusTarefa status) {
        return repository.listarPorEstatus(status);
    }

    public Tarefa moverTarefa(Integer id, StatusTarefa novoStatus) {
        var tarefaOpt = repository.buscarPorId(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefa = tarefaOpt.get();
            tarefa.setStatus(novoStatus);
            return repository.salvar(tarefa);
        }
        return null;
    }
    public boolean removerTarefa(Integer id){
        var tarefaOpt = repository.buscarPorId(id);
        if (tarefaOpt.isPresent()){
            repository.remover(id);
            return true;
        }
        return false;
    }
}
