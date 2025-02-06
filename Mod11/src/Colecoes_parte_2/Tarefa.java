package Colecoes_parte_2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tarefa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String resposta = "";
        Set<String> listaFeminino = new TreeSet<>();
        Set<String> listaMasculino = new TreeSet<>();

        do {
            System.out.println("Digite o nome de uma pessoa: ");
            String nome = s.next();

            System.out.println("Digite o sexo dessa pessoa: ");
            String sexo = s.next();

            verificaSexo(sexo);

            if (verificaSexo(sexo).equalsIgnoreCase("feminino")) {
                listaFeminino.add(nome);
            } else if (verificaSexo(sexo).equalsIgnoreCase("masculino")) {
                listaMasculino.add(nome);
            }

            System.out.println("Deseja adicionar mais um nome na lista? Digite 'Sim' ou 'Não'");
            resposta = s.next();

        } while (resposta.equalsIgnoreCase("Sim"));

        System.out.println(listaFeminino);
        System.out.println(listaMasculino);
    }

    public static String verificaSexo (String sexo) {

        if (sexo.equalsIgnoreCase("masculino")) {
            return "masculino";
        } else if (sexo.equalsIgnoreCase("feminino")) {
            return "feminino";
        } else {
            return "Você digitou o sexo incorretamente.";
        }
    }
}
