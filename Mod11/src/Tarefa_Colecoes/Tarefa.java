package Tarefa_Colecoes;

import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Tarefa parte 1
 * Ler do console nomes de pessoas separados por vírgula, guardar esses nomes em alguma lista,
 * ordenar em ordem alfabética e imprimir a lista no console. Fazer usando split.
 *
 * Tarefa parte 2
 * Ler do console "nome-sexo" (ex.: Marcos-M,Luana-F), separar os resultados em listas de grupos de gênero e
 * imprimir no console.
 */
public class Tarefa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Tarefa Parte1
        System.out.println("*** TAREFA 1 ***");
        Set<String> listaNomes = new TreeSet<>();

        System.out.println("Digite nomes separados por ',' :");
        String[] nomes = s.next().split(",");

        for (String e : nomes) {
            listaNomes.add(e.trim());
        }

        System.out.println("Set listaNomes " + listaNomes);

        System.out.println("");
        System.out.println("");

        //Tarefa Parte2
        System.out.println("*** TAREFA 2 ***");
        Set<String> listaMasculino = new TreeSet<>();
        Set<String> listaFeminino = new TreeSet<>();

        System.out.println("Digite o 'nome-sexo' (dessa mesma forma) e separe cada um com vírgula:");
        String entrada = s.next();

        String[] pares = entrada.split(",");

        for (String par : pares) {
            String[] dados = par.split("-");
            if (dados.length == 2) {
                String nome = dados[0];
                String sexo = dados[1];

                if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
                    listaMasculino.add(nome);
                } else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
                    listaFeminino.add(nome);
                }
            }
        }

        System.out.println("Nomes masculinos: " + listaMasculino);
        System.out.println("Nomes femininos: " + listaFeminino);
    }
}
