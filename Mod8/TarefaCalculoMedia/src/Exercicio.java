public class Exercicio {
    public static void main(String[] args) {
        calculoMedia();
    }

    private static void calculoMedia() {
        int nota1 = 2;
        int nota2 = 5;
        int nota3 = 9;
        int nota4 = 6;
        int resultado = (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.println("A média da nota é: " + resultado);
    }

}
