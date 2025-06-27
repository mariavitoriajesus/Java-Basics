package AtividadeMenu;

import java.util.Scanner;

public class MaquinaDeBanhoPet {
    private int agua = 0;
    private int shampoo = 0;
    private boolean temPet = false;
    private boolean petLimpo = false;
    private final int MAX_AGUA = 30;
    private final int MAX_SHAMPOO = 20;

    void menu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== MENU PETSHOP =====");
            System.out.println("1 - Colocar pet na máquina");
            System.out.println("2 - Dar banho no pet");
            System.out.println("3 - Retirar pet da máquina");
            System.out.println("4 - Abastecer com água");
            System.out.println("5 - Abastecer com shampoo");
            System.out.println("6 - Verificar nível de água");
            System.out.println("7 - Verificar nível de shampoo");
            System.out.println("8 - Verificar se há pet na máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> colocarPet();
                case 2 -> darBanho();
                case 3 -> retirarPet();
                case 4 -> abastecerAgua();
                case 5 -> abastecerShampoo();
                case 6 -> System.out.println("Nível de água: " + agua + " litros");
                case 7 -> System.out.println("Nível de shampoo: " + shampoo + " litros");
                case 8 -> System.out.println(temPet ? "Há um pet na máquina." : "Não há pet na máquina.");
                case 9 -> limparMaquina();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void colocarPet() {
        if (temPet) {
            System.out.println("Já há um pet na máquina.");
        } else {
            temPet = true;
            petLimpo = false;
            System.out.println("Pet colocado na máquina.");
        }
    }

    private void darBanho() {
        if (!temPet) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        if (agua < 10 || shampoo < 2) {
            System.out.println("Nível insuficiente de água ou shampoo.");
            return;
        }
        agua -= 10;
        shampoo -= 2;
        petLimpo = true;
        System.out.println("Banho realizado com sucesso!");
    }

    private void retirarPet() {
        if (!temPet) {
            System.out.println("Não há pet para retirar.");
        } else if (!petLimpo) {
            System.out.println("O pet não está limpo. Será necessário limpar a máquina.");
            temPet = false;
        } else {
            temPet = false;
            System.out.println("Pet limpo retirado com sucesso!");
        }
    }

    private void abastecerAgua() {
        if (agua + 2 <= MAX_AGUA) {
            agua += 2;
            System.out.println("2 litros de água adicionados. Nível atual: " + agua + " litros");
        } else {
            System.out.println("Capacidade máxima de água atingida.");
        }
    }

    private void abastecerShampoo() {
        if (shampoo + 2 <= MAX_SHAMPOO) {
            shampoo += 2;
            System.out.println("2 litros de shampoo adicionados. Nível atual: " + shampoo + " litros");
        } else {
            System.out.println("Capacidade máxima de shampoo atingida.");
        }
    }

    private void limparMaquina() {
        if (agua < 10 || shampoo < 2) {
            System.out.println("Nível insuficiente de água ou shampoo para limpeza.");
            return;
        }
        agua -= 10;
        shampoo -= 2;
        petLimpo = true;
        System.out.println("Máquina limpa e pronta para uso.");
    }

}
