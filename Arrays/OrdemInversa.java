package Arrays;
/*
Crie um vetor de 6 números inteiros e mostre-os na ordem inversa.
 */
public class OrdemInversa {
    public static void main(String[] args) {
        int []vetor = {0,8,7,4,6,4};

        System.out.println(vetor.length);

        int count = 0;
        while (count < (vetor.length -1)) {
            System.out.print(vetor[count] + " ");
            count++;
        }
        System.out.println("\n Vetor: ");
        for (int i = (vetor.length-1); i == 0; i--) {
            System.out.print(vetor[i] + " ");
        }
    }
}
