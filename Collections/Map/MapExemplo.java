package Collections.Map;
import javax.sound.midi.Soundbank;
import java.util.*;
/*
 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
 modelo = gol - consumo = 14,4km/l
 modelo = uno - consumo = 15,6 km/l
 modelo = mobi - consumo = 16,1 km/l
 modelo = hb20 - consumo = 14,5 km/l
 modelo = kwid - consumo = 15,6 km/l

Formas de iniciar um map:
   Map carrosPopulares2020 = new HashMap(); //antes do java 5
        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
        HashMap<String, Double> carrosPopulares = new HashMap<>();
        Map<String, Double> carrosPopulares2020 =
        Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)
 */
public class MapExemplo {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("\nSubstitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("\nConfira se o modelo tucson está no dicionario: " + carrosPopulares.containsKey("tuckson"));

        System.out.println("\nExiba o consumo do uno: "+ carrosPopulares.get("uno"));

        System.out.println("\nExiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(carrosPopulares);

        System.out.println("\nExiba os consumos dos carros: ");
        carrosPopulares.values();
        System.out.println(carrosPopulares);

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEfi =  Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEfi = "";
        for (Map.Entry<String, Double> entry: entries ) {
            if (entry.getValue().equals(consumoMaisEfi)) {
                modeloMaisEfi = entry.getKey();
                System.out.println("Modelo mais eficiente " + modeloMaisEfi + " - " + consumoMaisEfi);
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEfi = Collections.min(carrosPopulares.values());
        String modeloMenosEfi = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet() ) {
            if (entry.getValue().equals(consumoMenosEfi)) {
                modeloMenosEfi = entry.getKey();
                System.out.println("Modelo menis eficiente " + modeloMenosEfi + " - " + consumoMenosEfi);
            }
        }

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("\nExiba a soma dos consumos: " + soma);

        System.out.println("\nExiba a média dos consumos: " + (soma/carrosPopulares.size()));

        System.out.println("\nRemova os modelos com consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("\nExiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("\nApague o dicionario de carros: ");
        carrosPopulares.clear();

        System.out.println("\nConfira se o dicionario está vazio: " + carrosPopulares.isEmpty());

    }
}
