package Arrays;

import java.util.Random;

/*
Faça um programa que leia 20 números inteiros aleatórios (0 e 100) armazene-os num vetor.
Ao fianç mostre os números e seus sucessores.
 */
public class numerosAleatorios {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numerosaleatorios = new int[20];

        for (int i =0; i < numerosaleatorios.length; i++) {
            int numeros = random.nextInt(100);
            numerosaleatorios[i] = numeros;
        }

        System.out.println("Nuúmeros aleatorios: ");
        for (int numero : numerosaleatorios) {
            System.out.println(numero);
        }

        System.out.println("\n Nuúmeros sucessores: ");
        for (int numero : numerosaleatorios) {
            System.out.println((numero+1) + " ");
        }
    }
}
