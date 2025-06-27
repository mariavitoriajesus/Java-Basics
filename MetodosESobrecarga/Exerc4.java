package MetodosESobrecarga;
/*
Exercicío de Sobrecarga
Crie uma operação que calcula a área dos 3 quadriláteros notáveis: quadrado, retângulo e trapézio.

 */
public class Exerc4 {
    public static double area(double lado) {
        System.out.println("Área do quadrado:" + lado * lado);
        return lado;
    }
    public static void area(double lado1, double lado2) {
        System.out.println("Área do retângulo:" + lado1 * lado2);
        return;
    }
    public static double area(double baseMaior, double baseMenor, double altura) {
        System.out.println("Área do trapézio:" + ((baseMaior+baseMenor)*altura) / 2);
        return baseMaior;
    }
    public static double area(float diagonal1, float diagonal2) {
        System.out.println("Área do losango:" + (diagonal1 * diagonal2)/2);
        return 0;
    }
    public static void xpto() {
        System.out.println("Antes");
        return;
    }
    public static double abc() {
        return 1.6;
    }

    public static void main(String[] args) {
        System.out.println("Exercício quadrilátero");
        Exerc4.area(3);
        Exerc4.area(5d,5d);
        Exerc4.area(7,8,9);
        Exerc4.area(5f,5f);
        ///////////
        double areaQuadrado = Exerc4.area(3);
        System.out.println("Área do quadrado:" + areaQuadrado);

        double areaRetangulo = Exerc4.area(5,5);
        System.out.println("Área do retângulo:" + areaRetangulo);

        double areaTrapezio = Exerc4.area(7,8,9);
        System.out.println("Área do trapézio:" + areaTrapezio);

    }
}
