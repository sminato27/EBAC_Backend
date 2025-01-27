package ifelse;

import java.util.Scanner;

public class ExemploPPT2Console {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite um número:");

        int result = s.nextInt();

        if (result > 1 && result < 5) {
            System.out.println("Resultado entre 2 e 4");
        } else if (result >= 5 && result < 8) {
            System.out.println("Resultado entre 5 e 7");
        } else {
            System.out.println("Resultado diferente dos anteriores");
        }
    }
}
