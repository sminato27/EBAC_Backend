package set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet não tem ordem.
 * O acesso aos dados é mais rápido que em um TreeSet, mas nada garante que os dados estarão ordenados.
 * Não repete valores na lista.
 *
 */

public class ExemploHashSet {
    public static void main(String[] args) {
        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();

    }

    /**
     * Não repete valores na lista.
     */
    public static void exemploListaSimples() {
        System.out.println("*** exemploListaSimples ***");
        Set<String> lista = new HashSet<>();
        lista.add("Joao da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lucia Ferreira");
        lista.add("Joao da Silva");
        System.out.println(lista);
        System.out.println("");
    }

    public static void exemploListaSimplesOrdemAscendente() {
        System.out.println("*** exemploListaSimplesOrdemAscendente *** ");
        Set<String> lista = new HashSet<>();
        lista.add("Joao da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lucia Ferreira");
        //Collections.sort(lista);
        System.out.println(lista);
        System.out.println("");
    }
}
