package AtividadeMenu;

import java.util.Scanner;

public class Carro {
    private boolean ligado = false;
    private int velocidade = 0;
    private int marcha = 0;

    public void menu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== MENU DO CARRO =====");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda");
            System.out.println("6 - Virar para direita");
            System.out.println("7 - Verificar velocidade");
            System.out.println("8 - Trocar marcha");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> ligar();
                case 2 -> desligar();
                case 3 -> acelerar();
                case 4 -> desacelerar();
                case 5 -> virar("esquerda");
                case 6 -> virar("direita");
                case 7 -> verificarVelocidade();
                case 8 -> trocarMarcha(scanner);
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado!");
        } else {
            System.out.println("O carro já esta ligado'");
        }
    }

    private void desligar() {
        if (ligado && velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado!");
        } else if (!ligado) {
            System.out.println("O carro já esta desligado! ");
        } else {
            System.out.println("Não é possível desligar o carro em movimento ou fora do ponto morto.");
        }
    }

    private void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        if (marcha == 0) {
            System.out.println("O carro esta em ponto morto. Não e possivel acelerar.");
            return;
        }
        if (velocidade < 120) {
            int novaVelocidade = velocidade + 1;
            if (verificaVelocidadePorMacha(novaVelocidade)) {
                velocidade = novaVelocidade;
                System.out.println("Velocidade atual: " + velocidade + " km/h");
            } else {
                System.out.println("Essa velocidade não é permitida para a marcha atual.");
            }
        } else {
            System.out.println("Velocidade máxima atingida.");
        }
    }

    private void desacelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        if (velocidade > 0) {
            velocidade--;
            System.out.println("Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O carro já esta parado.");
        }
    }

    private void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
        } else if (velocidade >= 1 && velocidade <= 40 ) {
            System.out.println("Virando para a " + direcao + ".");
        } else {
            System.out.println("Velocidade inapropriada para virar. Reduza para até 40 km/h.");
        }
    }

    private void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h | Marcha: " + marcha);
    }

    private void trocarMarcha(Scanner scanner) {
        System.out.print("Informe a nova marcha (0 a 6): ");
        int novaMarcha = scanner.nextInt();

        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
        } else if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Não é permitido pular marchas.");
        } else {
            if (verificaVelocidadePorMacha(velocidade,novaMarcha)){
                marcha = novaMarcha;
                System.out.println("Marcha alterada para: " + marcha);
            } else {
                System.out.println("A velocidade atual não é compatível com a nova marcha.");
            }
        }
    }

    private boolean verificaVelocidadePorMacha(int v) {
        return verificaVelocidadePorMacha(v, marcha);
    }

    private boolean verificaVelocidadePorMacha(int v, int m) {
        return switch (m) {
            case 0 -> v == 0;
            case 1 -> v >= 0 && v <= 20;
            case 2 -> v >= 21 && v <= 40;
            case 3 -> v >= 41 && v <= 60;
            case 4 -> v >= 61 && v <= 80;
            case 5 -> v >= 81 && v <= 100;
            case 6 -> v >= 101 && v <= 120;
            default -> false;
        };
    }

}
