package Collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Dadas as seguintes informações sobre meus gatos, crie uma lista e ordene esta lista exibindo:
(nome - idade - cor);

Gato 1 = Nome: Jon, idade: 18, Cor: preto
Gato 2 = Nome: Simba, idade: 6, Cor: tigrado
Gato 3 = Nome: Jon, idade: 12, Cor: amarelo
 */
public class ListOrdenadoExemplo {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};
        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem de Aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural(Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t--");
        Collections.sort(meusGatos, new ComparetorIdade());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Cor\t--");
        meusGatos.sort(new ComparetorCor());
        System.out.println(meusGatos);
        
        System.out.println("--\tOrdem Nome/Cor/Idade\t--");
        meusGatos.sort(new ComparetorNomeCorIdade());
        System.out.println(meusGatos);

    }
}

class Gato implements Comparable<Gato> {
    private String nome;
    private int idade;
    private String cor;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}// class

class ComparetorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato o1, Gato o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}// class compare idade

class ComparetorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato o1, Gato o2) {
        return o1.getCor().compareToIgnoreCase(o2.getCor());
    }
}//class Compare cor

class ComparetorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato o1, Gato o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome()); // nome
        if (nome != 0) return nome;

        int cor = o1.getCor().compareToIgnoreCase(o2.getCor()); // cor
        if (cor != 0) return cor;

        return Integer.compare(o1.getIdade(), o2.getIdade()); // idade
    }
}