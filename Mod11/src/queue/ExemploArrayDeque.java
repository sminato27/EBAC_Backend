package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExemploArrayDeque {
    public static void main(String[] args) {
        inserindoNaFila();
        acessandoDaFila();
        removendoDaFila();
    }

    private static void acessandoDaFila() {
        System.out.println("*** Acessando ***");
        Deque<String> ab = new ArrayDeque<>();
        ab.add("Vermelho");
        ab.add("Azul");
        ab.add("Branco");
        ab.add("Amarelo");
        ab.add("Preto");

        Deque<String> b = new ArrayDeque<>();
        b.add("Verde");
        b.add("Roxo");

        ab.addAll(b);

        System.out.println(ab);
        System.out.println(ab.contains("Branco"));
        System.out.println(b.contains("Marrom"));
        System.out.println(b.containsAll(b));

        System.out.println("Output do primeiro elemento da deque: " + ab.element());
        System.out.println("Pega o primeiro elemento usando getFirst: " +ab.getFirst());
        System.out.println("Pega o último elemento usando getLast: " +ab.getLast());
        System.out.println("Output do primeiro elemento da deque: " +ab.peek());
        System.out.println("Pega o primeiro elemento usando peekFirst: " +ab.peekFirst());
        System.out.println("Pega o último elemento usando peekLastt: " +ab.peekLast());
        System.out.println("");

    }

    private static void inserindoNaFila() {
        System.out.println("*** Inserindo ***");

        Deque<String> c = new ArrayDeque<>();
        c.add("Portugal");
        c.addFirst("Brasil");
        c.addLast("EUA");

        System.out.println("Elementos do Deque após o add, addFirst e addLast: " + c);

        Deque<String> cd = new ArrayDeque<>();
        cd.add("Bangladesh");
        cd.add("Japão");

        c.addAll(cd);

        System.out.println("Elementos do Deque depois do addAll:" + c);

        boolean val = c.offer("China");
        c.offerFirst("Coreia");
        c.offerLast("India");

        System.out.println("Elementos do Deque depois do offer, offerFirst, offerLast: " + c);

        c.push("Argentina");

        System.out.println("Elementos do Deque depois do push: " + c);
        System.out.println("");

    }

    private static void removendoDaFila() {
        System.out.println("*** Removendo ***");

        Deque<String> ab = new ArrayDeque<>();
        ab.add("Vermelho");
        ab.add("Azul");
        ab.add("Branco");
        ab.add("Amarelo");
        ab.add("Preto");

        Deque<String> b = new ArrayDeque<>();
        b.add("Verde");
        b.add("Roxo");
        b.add("Rosa");
        b.add("Laranja");
        b.add("Marrom");

        ab.addAll(b);
        System.out.println("Elementos no ArrayDeque: "+ ab);

        String val = ab.remove(); //Remove o próximo da fila e coloca numa variável.
        ab.remove("Preto"); //Remove qual item quiser.

        System.out.println("Elementos no ArrayDeqye depois de remover: " + ab);

        ab.removeFirst();
        ab.removeLast();

        System.out.println("Elementos no ArrayDeque depois de remover o primeiro e o último: " + ab);

        ab.poll();
        ab.pollFirst();
        ab.pollLast();

        System.out.println("Elementos no ArrayDeque depois do poll, pollFirst e pollLast: " + ab);

        ab.pop();
        System.out.println("Elementos no ArrayDeque depois do pop: " + ab);

        ab.retainAll(b);
        System.out.println("Elementos no ArrayDeque depois do retainAll: " + ab);

        ab.removeAll(b);
        System.out.println("Elementos no ArrayDeque depois do removeAll:" + ab);
        System.out.println("");
    }
}
