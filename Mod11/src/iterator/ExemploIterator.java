package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExemploIterator {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Joao");
        l.add("Marcos");
        l.add("Jessica");

        Iterator<String> it = l.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
