package forwhile;

import java.util.ArrayList;
import java.util.List;

public class ExemploPPT1 {
    public static void main(String[] args) {

        List<Integer> valores = new ArrayList<>();
        // For que usa contador e sabe-se a quantidade de itens
        for (int i = 0; i <= 10; i++) {
            System.out.println("Linha " + i);
            valores.add(i);
        }

        //For que usa coleção e não se sabe a quantidade de itens
        for (Integer i : valores) {
            System.out.println("Linha " + i);
        }

        // For em lambda
        valores.forEach(i-> System.out.println("Linha " + i));
    }
}
