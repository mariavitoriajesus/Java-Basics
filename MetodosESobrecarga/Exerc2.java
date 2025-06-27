package MetodosESobrecarga;
/*
Crie uma aplicação que resolva a seguinte situação:
- A partir da hora do dia, informe a mensagem adequada.
 */
public class Exerc2 {
    public static void obterMensagem(int hora){
        switch (hora) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            mensagemBomDia();
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                mensagemBoaTarde();
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                mensagemBoaNoite();
                break;
            default:
                System.out.println("Hora inválida.");
                break;
        }
    }

    private static void mensagemBoaNoite() {
        System.out.println("Bom dia!");
    }
    private static void mensagemBoaTarde() {
        System.out.println("Boa tarde!");
    }
    private static void mensagemBomDia() {
        System.out.println("Boa noite!");
    }

    public static void main(String[] args) {
        System.out.println("Exercício mensagem");
        Exerc2.obterMensagem(9);
        Exerc2.obterMensagem(14);
        Exerc2.obterMensagem(1);
    }
}
