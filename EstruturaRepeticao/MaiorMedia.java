package EstruturaRepeticao;

import java.util.Scanner;

/*
Faça um programa que leia 5 números e informe o maior número e a média desses números.
 */
public class MaiorMedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeros;
        int maior = 0;
        int soma = 0;
        int cont = 0;

        do {
            System.out.println("Número: ");
            numeros = scan.nextInt();
            soma = soma + numeros;
            if(numeros > maior) maior = numeros;
            cont = cont + 1;
        } while (cont < 5);
        System.out.println("Maior: " + maior);
        System.out.println("Soma dos números: " + soma);
        System.out.println("Média: " + soma/5);

    }// main
}
