package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * É como um array cujo tamanho pode crescer.
 * A busca de um elemento é rápida, mas inserções e exclusões não são.
 * Bom para criar listas que podem ter itens duplicados em lugares aleatórios.
 */

public class ExemploArrayList {

    public static void main(String[] args) {

        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();
        exemploNumeros();

    }

    private static void exemploNumeros() {
        System.out.println("*** exemploNumeros ***");
        List<Integer> numeros = new ArrayList<>();
        numeros.add(4);
        numeros.add(8);
        numeros.add(2);
        System.out.println(numeros);
        System.out.println("");
    }

    private static void exemploListaSimples() {
        System.out.println("*** exemploListaSimples ***");
        List<String> lista = new ArrayList<>();
        lista.add("Joao da Silva");
        lista.add("Antônio Sousa");
        lista.add("Lucia Ferreira");
        System.out.println(lista);
        System.out.println("");
    }

    private static void exemploListaSimplesOrdemAscendente() {
        System.out.println("*** exemploListaSimplesOrdemAscendente ***");
        List<String> lista = new ArrayList<>();
        lista.add("Jorge Mendes");
        lista.add("Angelo Fagundes");
        lista.add("Leticia Lima");
        Collections.sort(lista); //Classe que ordena a coleção.
        System.out.println(lista);
        System.out.println("");
    }
}
