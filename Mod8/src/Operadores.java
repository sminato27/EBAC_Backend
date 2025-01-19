public class Operadores {
    public static void main(String[] args) {
        operacoesAritmeticas();
        operacoesAtribuicoes();
        operacoesIncrementoDecremento();
        operacoesRelacionais();
        operacoesLogicas();

    }

    private static void operacoesLogicas() {
        System.out.println("*** Operações Lógicas ***");
        int num1 = 10;

        boolean isDentro10 = num1 >= 1 && num1 <= 10;
        System.out.println("isDentro10: " + isDentro10);

        boolean isDentro_10 = num1 >= 1 || num1 <= 10;
        System.out.println("isDentro_10: " + isDentro_10);

        boolean isNot = num1 >= 1;
        System.out.println("isNot: " + !isNot);
    }

    private static void operacoesRelacionais() {
        System.out.println("*** Operações Relacionais ***");
        int num1 = 10;
        int num2 = 10;

        boolean isMaior = num1 > num2;
        System.out.println("isMaior: " + isMaior);

        boolean isIgual = num1 == num2;
        System.out.println("isIgual: " + isIgual);

        boolean isDiff = num1 != num2;
        System.out.println("isDiff: " + isDiff);

        boolean isMaiorIgual = num1 >= num2;
        System.out.println("isMaiorIgual: " + isMaiorIgual);

    }

    private static void operacoesIncrementoDecremento() {
        System.out.println("*** Operações Incremento e Decremento ***");
        int num1 = 10;
        System.out.println(num1);
        num1++;
        System.out.println(num1);
        num1--;
        System.out.println(num1);
    }

    private static void operacoesAtribuicoes() {
        System.out.println("*** Operações Atribuições ***");
        int num1 = 10;
        int num2 = 10;
        int num3 = num1 + num2;
        System.out.println(num3);
        num3 += num1;
        System.out.println(num3);
    }

    public static void operacoesAritmeticas() {
        System.out.println("*** Operações Aritméticas ***");

        int num1 = 10;
        int num2 = 20;

        int num3 = num1 + num2;
        System.out.println(num3);

        int num4 = num1 - num2;
        System.out.println(num4);

        int num5 = num1 / num2;
        System.out.println(num5);

        int num6 = num1 * num2;
        System.out.println(num6);

        int num7 = (num1 + num2) / 2;
        System.out.println(num7);
    }
}
