package list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Ao contrário do ArrayList, as buscas são lentas, mas inserções e exclusões são rápidas.
 */
public class ExemploLinkedList {

    public static void main(String[] args) {
        exemploLinkedListaSimples();
        exemploLinkedListaSimplesOrdemAscendente();
    }

    private static void exemploLinkedListaSimples() {
        System.out.println("*** exemploLinkedListaSimples ***");
        List<String> lista = new LinkedList<>();
        lista.add("Joao da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lucia Ferreira");
        System.out.println(lista);
        System.out.println("");

        lista.remove(0); //Remove um item da lista com base no index. O próximo ocupa o lugar do anterior.
        System.out.println(lista);
        boolean contem = lista.contains("Antonio Sousa"); //Verifica se contém na lista.
        System.out.println(contem);

        /**
         * Imprime todos os itens que estão na lista.
         */
        for (String nome : lista) {
            System.out.println(nome);
        }

        System.out.println(lista.get(0)); //Printa o item da lista com o get no index.

    }

    private static void exemploLinkedListaSimplesOrdemAscendente() {
        System.out.println("*** exemploLinkedListaSimplesOrdemAscendente ***");
        List<String> lista = new LinkedList<>();
        lista.add("Joao da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lucia Ferreira");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println("");
    }
}
