package set;

import java.util.Set;
import java.util.TreeSet;

/**
 * Os dados são classificados, mas o acesso é mais lento que no HashSet.
 * Não repete valores da lista.
 * Tem ordem natural dos objetos.
 */
public class ExemploTreeSet {
    public static void main(String[] args) {
        exemploListaSimples();
    }

    private static void exemploListaSimples() {
        System.out.println("*** exemploListaSimples ***");
        Set<String> lista = new TreeSet<>();

        lista.add("Joao da Silva");
        lista.add("Joao da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lucia Ferreira");

        System.out.println(lista);
        System.out.println("");
    }
}
