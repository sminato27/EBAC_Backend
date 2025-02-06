package list;

import java.util.ArrayList;
import java.util.List;

public class TestesPerformanceList {
    public static void main(String[] args) {
        testeArrayListAdd();
        testeArrayListRemove();
    }

    private static void testeArrayListAdd() {
        final int max = 20000; //Cria-se uma variável com um número máximo.
        long tInicio = System.currentTimeMillis(); //Pega o tempo de início em milissegundos.
        List<Integer> lista = new ArrayList<>(); //Instancia a lista.
        for (int i = 0; i < max; i++) { //Adiciona um item em cada posição da lista.
            lista.add(i);
        }

        for (int i = 0; i < max; i++) { //Checa o que cada item contém.
            lista.contains(i);
        }

        long tFim = System.currentTimeMillis(); //Pega o tempo final em milissegundos.
        System.out.println("Tempo total Arraylist ADD: " + (tFim - tInicio)); //Calcula o tempo que a operação levou.
    }

    private static void testeArrayListRemove() {
        final int max = 20000;
        long tInicio = System.currentTimeMillis();
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            lista.add(i);
        }

        for (int i = max - 1; i > 0; i--) {
            lista.remove(i);
        }

        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total Arraylist REMOVE: " + (tFim - tInicio));
    }
}
