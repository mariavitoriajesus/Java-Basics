package Collections.Set;

import java.util.*;

/*
Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
*/
public class SetOrdenadoExemplo {
    public static void main(String[] args) {
        System.out.println("--\t Ordem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>() {{
           add(new Serie("got", "fantasia", 60));
           add(new Serie("dark", "drama", 60));
           add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+ " - "
                + serie.getGenero() + " - " + serie.getTempo());
        //System.out.println(minhasSeries);

        System.out.println("\n--\t Ordem de inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+ " - "
                + serie.getGenero() + " - " + serie.getTempo());

        System.out.println("\n--\t Ordem natural (Tempo de Episodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+ " - "
                + serie.getGenero() + " - " + serie.getTempo());

        System.out.println("\n--\t Ordem Nome/Gênero/Tempo\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparetorNomeGeneroTempo());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+ " - "
                + serie.getGenero() + " - " + serie.getTempo());

    }
}

class Serie implements Comparable <Serie>{
    private String nome;
    private String genero;
    private int tempo;
    public Serie(String nome, String genero, int tempo) {
        this.nome = nome;
        this.genero = genero;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempo=" + tempo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return tempo == serie.tempo && nome.equals(serie.nome) && genero.equals(serie.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempo);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempo = Integer.compare(this.getTempo(), serie.getTempo());
        if (tempo != 0) return tempo;
        int genero = this.getGenero().compareTo(serie.getGenero());
        return this.getGenero().compareTo(serie.getGenero());

        //return Integer.compare(this.getTempo(), serie.getTempo());
    }
}// class serie

class ComparetorNomeGeneroTempo implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempo(), s2.getTempo());
    }
}

