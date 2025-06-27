package Collections.Set;

import java.util.*;

/*
Crie um conjunto contendo as cores do arco-íris é:
A. Exiba todas as cores abaixo da outra
B. A quantidade de cores que o arco-íris tem
C. Exiba as cores em ordem alfabética
D. Exiba as cores na ordem inversa da que foi informada
E. Exiba todas as cores que começam com a letra ”v”
F. Remova todas as cores que não começam com a letra “v”
G. Limpe o conjunto
H. Confira se o conjunto está vazio
 */
public class Set1 {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto contendo as cores do arco-íris: ");
        Set<String> cores = new HashSet<>();
        cores.add("violeta");
        cores.add("anil");
        cores.add("azul");
        cores.add("verde");
        cores.add("amarelo");
        cores.add("laranja");
        cores.add("vermelho");
        System.out.println(cores);

        System.out.println("Exiba todos as cores do arco-íris uma abaixo da outra: ");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("A quantidade de cores que o arco-íris possuí: " + cores.size());

        System.out.println("Exiba em ordem alfabética: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        System.out.println("Exiba na ordem inversa que foeam informadas: ");
        Set<String> cores3 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println(cores3);
        List<String> coresList = new ArrayList<>(cores3);
        Collections.reverse(coresList);

        System.out.println("Exiba as cores que começam com a letra v: ");
        for (String cor : cores) {
            if (cor.startsWith("v")) System.out.println(cor);
        }
        System.out.println(cores);

        System.out.println("Limpe o conjunto: ");
        cores.clear();

        System.out.println("Confira se o conjunto está vazio: " + cores.isEmpty());

    }
}
