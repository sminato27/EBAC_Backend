package list;

import domain.Aluno;
import domain.ComparaNotaAluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploArrayListAlunos {
    public static void main(String[] args) {
        exemploListaSimplesOrdenadaClasseExterna();
        exemploListaSimplesOrdenadaComparatorAluno();

    }

    private static void exemploListaSimplesOrdenadaClasseExterna() {
        System.out.println("*** exemploListaSimplesOrdenadaClasseExterna ***");
        List<Aluno> lista = new ArrayList<Aluno>();

        Aluno a = new Aluno("Joao da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lucia Ferreira", "Internet", 0);

        lista.add(a);
        lista.add(b);
        lista.add(c);

        System.out.println(lista);
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println("");
    }

    private static void exemploListaSimplesOrdenadaComparatorAluno() {
        System.out.println("*** exemploListaSimplesOrdenadaComparatorAluno ***");
        List<Aluno> lista = new ArrayList<>(); //Pode-se alterar para LinkedList.

        Aluno a = new Aluno("Joao da Silva", "Linux básico", 20);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice",30 );
        Aluno c = new Aluno("Lucia Ferreira", "Internet", 10);

        lista.add(a);
        lista.add(b);
        lista.add(c);

        System.out.println("Lista sem ordenação" + lista);
        Collections.sort(lista);
        System.out.println("Lista com ordenação" + lista);

        //Instancia-se também a classe de comparação.
        ComparaNotaAluno comparaNotaAluno = new ComparaNotaAluno();
        Collections.sort(lista, comparaNotaAluno); //Pega da lista e ordena com o comparaNotaAluno.
        System.out.println("Lista com ordenação por nota" + lista);
        System.out.println("");


    }
}
