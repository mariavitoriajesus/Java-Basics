package EstruturaRepeticao;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

/*
Faça um programa que paça N números inteiros, calcule e mostre a quantidade de números pares e
a quantidade de números impares.
 */
public class ParImpar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantNumeros;
        int numero;
        int quantPar =0, quantImpar =0;

        System.out.println("Quantidade de números: ");
        quantNumeros = scan.nextInt();

        int cont = 0;
        do {
            System.out.println("Número: ");
            numero = scan.nextInt();
            if (numero % 2 ==0) quantPar++;
            else quantImpar++;
            cont++;
        } while (cont < quantNumeros);
        System.out.println("Quantidade Par: " + quantPar);
        System.out.println("Quantidade Impar: " + quantImpar);
    }
}
