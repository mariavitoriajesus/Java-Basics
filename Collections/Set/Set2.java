package Collections.Set;

import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e ide.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
A. Ordem de Inserção
B. Ordem Natural (nome)
C. IDE
D. Ano de criação e nome
E. Nome, ano de criacao e IDE
Ao final, exiba as linguagens no console, um abaixo da outra.
 */
public class Set2 {
    public static void main(String[] args) {
        Set<LinguegemFavorita> minhasLinguagens = new HashSet<>();
        minhasLinguagens.add(new LinguegemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagens.add(new LinguegemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagens.add(new LinguegemFavorita("Java", 1991, "Visual Studio Code"));

        System.out.println("--------\tOrdem de Inserção\t--------");
        Set<LinguegemFavorita> minhasLinguagens1 = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguegemFavorita("Python", 1991, "Pycharm"),
                        new LinguegemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguegemFavorita("Java", 1991, "Visual Studio Code")
                )
        );
        for (LinguegemFavorita linguagem : minhasLinguagens1) System.out.println(linguagem);

        System.out.println("--------\tOrdem natural: Nome\t--------");
        Set<LinguegemFavorita> minhasLinguagens2 = new TreeSet<>(minhasLinguagens);
        for (LinguegemFavorita linguagem : minhasLinguagens2) System.out.println(linguagem);

        System.out.println("--------\tOrdem IDE\t--------");
        Set<LinguegemFavorita> minhasLinguagens3 = new TreeSet<LinguegemFavorita>(new ComparatorIde());
        minhasLinguagens3.addAll(minhasLinguagens);
        for (LinguegemFavorita linguagem: minhasLinguagens3) System.out.println(linguagem);

        System.out.println("--------\tOrdem Ano de Criação e Nome\t--------");
        Set<LinguegemFavorita> minhasLingaugens4 = new TreeSet<LinguegemFavorita>(new ComparatorAno());
        minhasLingaugens4.addAll(minhasLinguagens);
        for (LinguegemFavorita linguagem: minhasLingaugens4) System.out.println(linguagem);

        System.out.println("--------\tOrdem Nome - Ano de Criação - IDE\t--------");
        Set<LinguegemFavorita> minhasLinguagens5 = new TreeSet<LinguegemFavorita>(new ComparatorNome());
        minhasLinguagens5.addAll(minhasLinguagens3);
        for (LinguegemFavorita linguegem : minhasLinguagens5) System.out.println(linguegem);

    }
}

class LinguegemFavorita implements Comparable<LinguegemFavorita> {
    public String nome;
    public Integer anoCriacao;
    public String ide;

    public LinguegemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "LinguegemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguegemFavorita o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguegemFavorita that = (LinguegemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoCriacao, that.anoCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }
}

class ComparatorIde implements Comparator<LinguegemFavorita> {
    @Override
    public int compare(LinguegemFavorita lf1, LinguegemFavorita lf2) {
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
}

class ComparatorAno implements Comparator<LinguegemFavorita>{
    @Override
    public int compare(LinguegemFavorita lf1, LinguegemFavorita lf2) {
        int anoCriacao = Integer.compare(lf1.anoCriacao, lf2.anoCriacao);
        if (anoCriacao !=0) return anoCriacao;
        return lf1.nome.compareToIgnoreCase(lf2.nome);
    }
}

class ComparatorNome implements Comparator<LinguegemFavorita> {
    @Override
    public int compare(LinguegemFavorita lf1, LinguegemFavorita lf2) {
        int nome = lf1.nome.compareToIgnoreCase(lf2.nome);
        int anoCriacao = Integer.compare(lf1.anoCriacao, lf2.anoCriacao);
        if (nome != 0) return nome;
        if (anoCriacao != 0) return anoCriacao;
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
}