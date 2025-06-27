package AtividadeMenu;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();
        Carro carro = new Carro();
        MaquinaDeBanhoPet petshop = new MaquinaDeBanhoPet();

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Conta Bancária");
            System.out.println("2 - Simulador de Carro");
            System.out.println("3 - Banho Petshop");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    conta.menu(scanner);
                    break;
                case 2:
                    carro.menu(scanner);
                    break;
                case 3:
                    petshop.menu(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando aplicação...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

