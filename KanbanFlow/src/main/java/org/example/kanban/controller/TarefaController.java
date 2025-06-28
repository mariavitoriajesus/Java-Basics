package org.example.kanban.controller;

import org.example.kanban.Model.StatusTarefa;
import org.example.kanban.Model.Tarefa;
import org.example.kanban.service.TarefaService;

import java.util.Scanner;

public class TarefaController {
    private final TarefaService service;
    private final Scanner scanner;

    public TarefaController() {
        this.service = new TarefaService();
        this.scanner = new Scanner(System.in);
    }
    public void iniciar() {
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> moverTarefa();
                case 4 -> removerTarefa();
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    private void exibirMenu() {
        System.out.println("\n=== Board de Tarefas ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Mover Tarefa");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
    private void adicionarTarefa() {
        System.out.println("\n--- Adicionar Tarefa ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de Vencimento (AAAA-MM-DD): ");
        String dataVencimento = scanner.nextLine();

        Tarefa tarefa = service.criarTabela(titulo, descricao, dataVencimento);
        System.out.println("Tarefa adicionada com ID: " + tarefa.getId());
    }
    private void listarTarefas() {
        System.out.println("\n--- Listar Tarefas ---");
        System.out.println("\nTO DO:");
        service.listarTarefasPorStatus(StatusTarefa.TO_DO).forEach(System.out::println);

        System.out.println("\nDOING:");
        service.listarTarefasPorStatus(StatusTarefa.DOING).forEach(System.out::println);

        System.out.println("\nDONE:");
        service.listarTarefasPorStatus(StatusTarefa.DONE).forEach(System.out::println);
    }
    private void moverTarefa() {
        System.out.println("\n--- Mover Tarefa ---");
        System.out.print("ID da Tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Novo Status:");
        System.out.println("1. TO DO");
        System.out.println("2. DOING");
        System.out.println("3. DONE");
        System.out.print("Escolha o novo status: ");
        int statusOpcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        StatusTarefa novoStatus = switch (statusOpcao) {
            case 1 -> StatusTarefa.TO_DO;
            case 2 -> StatusTarefa.DOING;
            case 3 -> StatusTarefa.DONE;
            default -> null;
        };

        if (novoStatus != null) {
            Tarefa tarefa = service.moverTarefa(id, novoStatus);
            if (tarefa != null) {
                System.out.println("Tarefa movida com sucesso!");
            } else {
                System.out.println("Tarefa não encontrada!");
            }
        } else {
            System.out.println("Status inválido!");
        }
    }
    private void removerTarefa() {
        System.out.println("\n--- Remover Tarefa ---");
        System.out.print("ID da Tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (service.removerTarefa(id)) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }
}



