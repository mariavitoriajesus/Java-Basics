package Collections.Map;

import java.util.*;

/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);

Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
*/
public class MapOrdenacaoExemplo {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
           put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
           put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n--\tOrdem de inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros1.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n--\tOrdem alfabetica de autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro: meusLivros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n--\tOrdem alfabetica de nomes\t--");
        Set<Map.Entry<String,Livro>> meusLivros3 = new TreeSet<>(new ComparetorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        System.out.println(meusLivros3);
    }

}
 class Livro {
    private String nome;
    private int paginas;

     public Livro(String nome, int paginas) {
         this.nome = nome;
         this.paginas = paginas;
     }

     public String getNome() {
         return nome;
     }

     public int getPaginas() {
         return paginas;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Livro livro = (Livro) o;
         return paginas == livro.paginas && nome.equals(livro.nome);
     }

     @Override
     public int hashCode() {
         return Objects.hash(nome, paginas);
     }

     @Override
     public String toString() {
         return "Livro{" +
                 "nome='" + nome + '\'' +
                 ", paginas=" + paginas +
                 '}';
     }
 }

 class ComparetorNome implements Comparator<Map.Entry<String, Livro>> {

     @Override
     public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
         return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
     }
 }