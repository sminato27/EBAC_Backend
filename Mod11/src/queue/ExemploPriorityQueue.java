package queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Possui ordenação natural (nesse caso, ordem alfabética).
 */
public class ExemploPriorityQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("medio");
        queue.add("curto");
        queue.add("longo");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }
    }
}
