package MetodosESobrecarga;
/*
Crie uma aplicação que resolva a seguinte situações:
- Calcule as 4 operações básicas. Sempre 2 valores devem ser passados.
 */
public class Exerc1 {
    public static void soma (double num1, double num2) {
        double resultado = num1 + num2;
        System.out.println("A soma de: " + num1 + " + " + num2 + " = " + resultado);
    }
    public static void subtracao (double num1, double num2) {
        double resultado = num1 - num2;
        System.out.println("A subtração de: " + num1 + " - " + num2 + " = " + resultado);
    }
    public static void multiplicacao (double num1, double num2) {
        double resultado = num1 * num2;
        System.out.println("A multiplicação de: " + num1 + " X " + num2 + " = " + resultado);
    }
    public static void divisao (double num1, double num2) {
        double resultado = num1 / num2;
        System.out.println("A divisão de: " + num1 + " / " + num2 + " = " + resultado);
    }

    public static void main(String[] args) {
        System.out.println("Exercício 1 - calculadora");
        Exerc1.soma(8,6);
        Exerc1.subtracao(4,6);
        Exerc1.multiplicacao(4,9);
        Exerc1.divisao(12,3);
    }
}
