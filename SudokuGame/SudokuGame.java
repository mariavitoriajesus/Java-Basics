package Exercicios.SudokuGame;

import java.util.Scanner;

public class SudokuGame {
    private static int[][] board = new int[9][9];
    private static boolean[][] fixed = new boolean[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogoIniciado = false;
        int opcao;

        do {
            System.out.println("\n===== MENU SUDOKU =====");
            System.out.println("1. Iniciar novo jogo");
            System.out.println("2. Colocar um número");
            System.out.println("3. Remover um número");
            System.out.println("4. Verificar jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar números do jogador");
            System.out.println("7. Finalizar jogo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    iniciarJogoExemplo();
                    jogoIniciado = true;
                    break;
                case 2:
                    if (jogoIniciado) colocarNumero(scanner);
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 3:
                    if (jogoIniciado) removerNumero(scanner);
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 4:
                    if (jogoIniciado) exibirTabuleiro();
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 5:
                    if (jogoIniciado) verificarStatus();
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 6:
                    if (jogoIniciado) limparUsuario();
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 7:
                    if (jogoIniciado) finalizarJogo();
                    else System.out.println("Inicie o jogo primeiro!");
                    break;
                case 0:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    static void iniciarJogoExemplo() {
        int[][] exemplo = {
                {9,5,8,0,0,0,0,2,0},
                {0,0,0,2,5,6,0,4,0},
                {0,6,0,0,0,0,5,1,7},
                {6,0,0,3,7,8,0,0,0},
                {7,8,4,0,0,0,9,3,2},
                {0,0,0,4,2,9,0,0,8},
                {4,9,2,0,0,0,1,0,0},
                {0,6,0,5,8,1,0,0,0},
                {1,0,0,0,0,0,7,6,3}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = exemplo[i][j];
                fixed[i][j] = exemplo[i][j] != 0;
            }
        }

        System.out.println("Jogo iniciado!");
        exibirTabuleiro();
    }
    static void colocarNumero(Scanner scanner) {
        System.out.print("Número (1-9): ");
        int num = scanner.nextInt();
        System.out.print("Linha (1-9): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Coluna (1-9): ");
        int col = scanner.nextInt() - 1;

        if (fixed[row][col]) {
            System.out.println("Erro: essa posição é fixa e não pode ser alterada.");
        } else if (board[row][col] != 0) {
            System.out.println("Erro: já existe um número nessa posição.");
        } else if (num < 1 || num > 9) {
            System.out.println("Número inválido.");
        } else {
            board[row][col] = num;
            System.out.println("Número adicionado!");
        }
    }

    static void removerNumero(Scanner scanner) {
        System.out.print("Linha (1-9): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Coluna (1-9): ");
        int col = scanner.nextInt() - 1;

        if (fixed[row][col]) {
            System.out.println("Erro: essa posição é fixa e não pode ser removida.");
        } else if (board[row][col] == 0) {
            System.out.println("Essa posição já está vazia.");
        } else {
            board[row][col] = 0;
            System.out.println("Número removido.");
        }
    }

    static void exibirTabuleiro() {
        System.out.println("\nTabuleiro atual:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void verificarStatus() {
        boolean completo = true;
        boolean erro = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num == 0) {
                    completo = false;
                } else {
                    board[i][j] = 0;
                    if (!isValid(i, j, num)) erro = true;
                    board[i][j] = num;
                }
            }
        }

        if (!completo) System.out.print("Status: Incompleto");
        else System.out.print("Status: Completo");

        if (erro) System.out.println(" com ERROS.");
        else System.out.println(" sem erros.");
    }

    static void limparUsuario() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!fixed[i][j]) board[i][j] = 0;

        System.out.println("Todos os números do jogador foram removidos.");
    }

    static void finalizarJogo() {
        boolean completo = true;
        boolean erro = false;

        outer:
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num == 0) {
                    completo = false;
                    break outer;
                } else {
                    board[i][j] = 0;
                    if (!isValid(i, j, num)) {
                        erro = true;
                        break outer;
                    }
                    board[i][j] = num;
                }
            }

        if (!completo) {
            System.out.println("O jogo ainda não está completo.");
        } else if (erro) {
            System.out.println("O jogo está completo, mas contém erros.");
        } else {
            System.out.println("Parabéns! Você completou o Sudoku corretamente.");
        }
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == num || board[i][col] == num)
                return false;

        int boxRow = row / 3 * 3, boxCol = col / 3 * 3;
        for (int i = boxRow; i < boxRow + 3; i++)
            for (int j = boxCol; j < boxCol + 3; j++)
                if (board[i][j] == num)
                    return false;

        return true;
    }


}
