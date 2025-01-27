package forwhile;

public class ExemploPPT3 {
    public static void main(String[] args) {
        for (int contador = 1; contador <= 100; contador++) {
            // Checagem dos múltiplos de 5
            if (contador % 5 != 0) {
                continue;
            }
            System.out.println("Contador: " + contador);
        }

    }
}
