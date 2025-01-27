package ifelse;

public class ExemploPPT2 {
    public static void main(String[] args) {
        int result = 4;

        if (result > 1 && result < 5) {
            System.out.println("Resultado entre 2 e 4");
        } else if (result >= 5 && result < 8) {
            System.out.println("Resultado entre 5 e 7");
        } else {
            System.out.println("Resultado diferente dos anteriores");
        }
    }
}
