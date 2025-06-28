package org.example.kanban.Model;

import java.time.LocalDate;

public class Tarefa {
    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDate datavencimento;
    private StatusTarefa status;

    public Tarefa(Integer id, String titulo, String descricao, LocalDate datavencimento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.datavencimento = datavencimento;
        this.status = StatusTarefa.TO_DO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(LocalDate datavencimento) {
        this.datavencimento = datavencimento;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", datavencimento=" + datavencimento +
                ", status=" + status +
                '}';
    }
}
