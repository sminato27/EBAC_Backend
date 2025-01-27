package Tarefa_ControleFluxo;

import java.util.Scanner;

public class Tarefa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        int nota1 = s.nextInt();
        System.out.println("Digite a segunda nota: ");
        int nota2 = s.nextInt();
        System.out.println("Digite a terceira nota: ");
        int nota3 = s.nextInt();
        System.out.println("Digite a quarta nota: ");
        int nota4 = s.nextInt();

        int notas = getCalculo(nota1, nota2, nota3, nota4);
        String resultado = getResultado(notas);

        System.out.println("O aluno está: " + resultado);
    }

    public static int getCalculo (int nota1,int nota2,int nota3,int nota4) {
        int resultCalculo;
        resultCalculo = (nota1 + nota2 + nota3 + nota4) / 4;
        return resultCalculo;
    }


    public static String getResultado (int calculo) {
        if (calculo >= 7 && calculo <= 10) {
            return "Aprovado!";
        } else if (calculo >= 5 && calculo < 7) {
            return "de recuperação!";
        } else
            return "Reprovado!";
    }

}
