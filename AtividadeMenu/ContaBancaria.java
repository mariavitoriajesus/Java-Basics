package AtividadeMenu;

import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeUsado = 0;

    public ContaBancaria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor inicial da conta: R$  ");
        saldo = scanner.nextDouble();
        if (saldo < 500) {
            chequeEspecial = 50.0;
        } else {
            chequeEspecial = saldo * 0.5;
        }
        System.out.println("Conta criada com sucesso! Cheque especial: R$ " + chequeEspecial);
    }

    public void menu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== MENU CONTA BANCÁRIA =====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial disponível");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    consultarChequeEspecial();
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 4:
                    sacar(scanner);
                    break;
                case 5:
                    pagarBoleto(scanner);
                    break;
                case 6:
                    verificarUsoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    private void consultarChequeEspecial() {
        double disponivel = chequeEspecial - limiteChequeUsado;
        System.out.printf("Cheque especial disponível: R$ %.2f\n", disponivel);
    }

    private void depositar(Scanner scanner) {
        System.out.print("Digite o valor a depositar:R$ ");
        double valor = scanner.nextDouble();

        if (limiteChequeUsado > 0){
            double taxa = limiteChequeUsado * 0.2;
            double totalDivida = limiteChequeUsado +taxa;

            if (valor >= totalDivida){
                valor -= totalDivida;
                limiteChequeUsado = 0;
                System.out.printf("R$ %.2f foi usado para quitar o cheque especial (com taxa de 20%%).\n", totalDivida);
            } else {
                limiteChequeUsado -= valor /1.2;
                System.out.printf("R$ %.2f foi usado parcialmente para quitar o cheque especial.\n", valor);
                valor = 0;
            }
        }
        saldo += valor;
        System.out.printf("Depósito realizado. Saldo atual: R$ %.2f\n", saldo);
    }

    private void sacar(Scanner scanner) {
        System.out.print("Digite o valor a sacar:R$ ");
        double valor = scanner.nextDouble();
        if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor <= saldo * (chequeEspecial - limiteChequeUsado)) {
            double restante = valor - saldo;
            saldo = 0;
            limiteChequeUsado += restante;
            System.out.println("Saque realizado usando cheque especial.");
        } else {
            System.out.println("Saldo insuficiente!");
        }
        consultarSaldo();
    }

    private void pagarBoleto(Scanner scanner) {
        System.out.print("Digite o valor do boleto:R$ ");
        double valor = scanner.nextDouble();
        sacar(scanner);
    }

    private void verificarUsoChequeEspecial() {
        if (limiteChequeUsado > 0){
            System.out.printf("Você está usando R$ %.2f do cheque especial. Uma taxa de 20%% será cobrada ao repor esse valor.\n", limiteChequeUsado);
        } else {
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

}
