package map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A ordem de iteração é a ordem em que as chaves são inseridas no Map.
 */
public class ExemploLinkedHashMap {
    public static void main(String[] args) {
        exemploListaSimples();

    }

    public static void exemploListaSimples() {
        System.out.println("*** exemploListaSimples ***");
        Map<Integer, String> lista = new LinkedHashMap<>();

        lista.put(1, "Joao da Silva");
        lista.put(2, "Antonio Sousa");
        lista.put(4, "Joao da Silva");
        lista.put(3, "Lucia Ferreira");

        System.out.println(lista);
        System.out.println(" ");
    }
}
