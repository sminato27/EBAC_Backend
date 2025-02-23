package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Permite chaves e valores null. Não existe garantia que os dados ficarão ordenados.
 *
 * Para usar uma classe que implementa Map, quaisquer classes que forem utilizadas como chave
 * devem sobrescrever os métodos hashCode() e equals().
 */

public class ExemploHashMap {
    public static void main(String[] args) {
        exemploListaSimples();
        exemploListaSimplesIterandoValores();
        exemploListaSimplesIterandoChaves();
        exemploListaSimplesIterandoChaveValor();
    }

    /**
     *
     */
    public static void exemploListaSimples() {
        System.out.println("**** exemploListaSimples ****");

        Map<Integer, String> lista = new HashMap<>();

        lista.put(1, "Joao da Silva");
        lista.put(2, "Antonio Sousa");
        lista.put(4, "Joao da Silva");
        lista.put(3, "Lucia Ferreira");

        System.out.println(lista);
        System.out.println(" ");
    }

    public static void exemploListaSimplesIterandoValores() {
        System.out.println("*** exemploListaSimplesIterandoValores ***");

        Map<Integer, String> lista = new HashMap<>();

        lista.put(1, "Joao da Silva");
        lista.put(2, "Antonio Sousa");
        lista.put(3, "Lucia Ferreira");
        lista.put(4, "Joao da Silva");

        for (String valores : lista.values()) { // Itera os valores com o .values
            System.out.println(valores);
        }
    }

    public static void exemploListaSimplesIterandoChaves() {
        System.out.println("*** exemploListaSimplesIterandoChaves ***");

        Map<Integer, String> lista = new HashMap<>();

        lista.put(1, "Joao da Silva");
        lista.put(2, "Antonio Sousa");
        lista.put(3, "Lucia Ferreira");
        lista.put(4, "Joao da Silva");

        for (Integer valores : lista.keySet()) { // Itera as chaves com o .keySet
            System.out.println(valores);
        }
    }

    public static void exemploListaSimplesIterandoChaveValor() {
        System.out.println("*** exemploListaSimplesIterandoChaveValor ***");

        Map<Integer, String> lista = new HashMap<>();

        lista.put(1, "Joao da Silva");
        lista.put(2, "Antonio Sousa");
        lista.put(3, "Lucia Ferreira");
        lista.put(4, "Joao da Silva");

        System.out.println("*** for comum ***");
        Set<Map.Entry<Integer, String>> entry = lista.entrySet();
        for (Map.Entry<Integer, String> e : entry) {
            System.out.println("Chave: " + e.getKey());
            System.out.println("Valor: " + e.getValue());
        }

        System.out.println("*** forEach stream ***"); // Mesma coisa do FOR comum, mas usando stream
        lista.entrySet().forEach(e -> {
            System.out.println("Chave: " + e.getKey());
            System.out.println("Valor: " + e.getValue());
        });

        System.out.println("*** forEach stream 1 ***");
        lista.keySet().stream().forEach(System.out::println);

        System.out.println("*** forEach stream 2 ***");
        lista.values().stream().forEach(System.out::println);

        System.out.println("*** forEach stream 3 ***");
        lista.forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println("*** iterator ***");
        Iterator<Map.Entry<Integer, String>> it = lista.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry1 = it.next();
            System.out.println("Chave: " + entry1.getKey());
            System.out.println("Valor: " + entry1.getValue());
        }

    }
}
