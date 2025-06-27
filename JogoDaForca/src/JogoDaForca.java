import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private String palavraSecreta;
    private char[] palavraAdivinhada;
    private int tentativasRestantes;
    private List<Character> letrasTentadas;
    private boolean jogoTerminado;

    public JogoDaForca() {
        tentativasRestantes = 6;
        letrasTentadas = new ArrayList<>();
        jogoTerminado = false;
        selecionarPalavraSecreta();
        inicializarPalavraAdivinhada();
    }
    private void selecionarPalavraSecreta() {
        String[] palavras = {"JAVA", "PROGRAMACAO", "COMPUTADOR", "ALGORITMO",
                "DESENVOLVIMENTO", "OBJETO", "CLASSE", "ENCAPSULAMENTO"};
        Random random = new Random();
        palavraSecreta = palavras[random.nextInt(palavras.length)];
    }

    private void inicializarPalavraAdivinhada() {
        palavraAdivinhada = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraAdivinhada.length; i++) {
            palavraAdivinhada[i] = '_';
        }
    }
    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("A palavra tem " + palavraSecreta.length() + " letras.");

        while (!jogoTerminado) {
            exibirStatus();
            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toUpperCase();

            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Por favor, digite apenas uma letra válida.");
                continue;
            }

            char letra = entrada.charAt(0);
            tentarLetra(letra);
            verificarFimDeJogo();
        }

        scanner.close();
    }
    private void tentarLetra(char letra) {
        if (letrasTentadas.contains(letra)) {
            System.out.println("Você já tentou essa letra. Tente outra.");
            return;
        }

        letrasTentadas.add(letra);

        boolean letraEncontrada = false;
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraAdivinhada[i] = letra;
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            tentativasRestantes--;
            System.out.println("Letra não encontrada! Tentativas restantes: " + tentativasRestantes);
        }
    }
    private void verificarFimDeJogo() {
        if (tentativasRestantes <= 0) {
            jogoTerminado = true;
            System.out.println("Game Over! Você perdeu.");
            System.out.println("A palavra era: " + palavraSecreta);
        } else if (palavraSecreta.equals(String.valueOf(palavraAdivinhada))) {
            jogoTerminado = true;
            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
        }
    }
    private void exibirStatus() {
        System.out.println("\n" + desenharForca());
        System.out.println("Palavra: " + String.valueOf(palavraAdivinhada));
        System.out.println("Letras tentadas: " + letrasTentadas);
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    private String desenharForca() {
        StringBuilder sb = new StringBuilder();

        sb.append("  _______").append("\n");
        sb.append(" |/      |").append("\n");

        switch (6 - tentativasRestantes) {
            case 0:
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                break;
            case 1:
                sb.append(" |      O").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                break;
            case 2:
                sb.append(" |      O").append("\n");
                sb.append(" |      |").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                break;
            case 3:
                sb.append(" |      O").append("\n");
                sb.append(" |     /|").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                break;
            case 4:
                sb.append(" |      O").append("\n");
                sb.append(" |     /|\\").append("\n");
                sb.append(" |").append("\n");
                sb.append(" |").append("\n");
                break;
            case 5:
                sb.append(" |      O").append("\n");
                sb.append(" |     /|\\").append("\n");
                sb.append(" |     /").append("\n");
                sb.append(" |").append("\n");
                break;
            case 6:
                sb.append(" |      O").append("\n");
                sb.append(" |     /|\\").append("\n");
                sb.append(" |     / \\").append("\n");
                sb.append(" |").append("\n");
                break;
        }

        sb.append("_|___").append("\n");
        return sb.toString();
    }

}
