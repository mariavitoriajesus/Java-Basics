package MetodosESobrecarga;
/*
Crie uma aplicação que resolva a seguinte situação:

Calcule o valor final de um empréstimo a partir do valor solicitado. Taxas e parcelas influenciam.
Defina arbitrariamente as faixas que influenciam.
 */
public class Exerc3 {
    public static int getDuasParcelas() {
        return 2;
    }
    public static int getTresParcelas() {

        return 3;
    }
    public static double getTaxaDuasParcelas() {

        return 0.3;
    }
    public static double getTaxaTresParcelas() {

        return 0.45;
    }
    public static void calcular(double valor, int parcelas) {
        if (parcelas == 2) {
            double valorFinal = valor + (valor + getTaxaDuasParcelas());
            System.out.println("Valor final do emprestimo para 2 parcelas: R$ " + valorFinal);
        } else if (parcelas == 3) {
            double valorFinal = valor + (valor + getTaxaTresParcelas());
            System.out.println("Valor final do emprestimo para 2 parcelas: R$ " + valorFinal);
        } else {
            System.out.println("Quantidade de parcelas não aceita.");
        }
    }// calcular
    public static void main(String[] args) {
        System.out.println("Exercício empréstimo");
        Exerc3.calcular(1000, Exerc3.getDuasParcelas());
        Exerc3.calcular(1000, Exerc3.getTresParcelas());
        Exerc3.calcular(1000, 5);
    }// main
}
