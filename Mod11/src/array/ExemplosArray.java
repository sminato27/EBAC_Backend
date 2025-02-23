package array;

public class ExemplosArray {
    public static void main(String[] args) {
        declaracaoArray();
        tamanhoArray();
        percorrendoArray();
        percorrendoArray2();
        arrayBidimensional();
        novoArray();
    }

    public static void novoArray() {
        System.out.println("*** novoArray ***");
        String[] nomes = new String[4];
        nomes[0] = "Guilherme";
        nomes[1] = "Paim";
        nomes[2] = "Minato";
        nomes[3] = "Sahashi";
        // System.out.println(nomes[0]);

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    private static void declaracaoArray() {
        System.out.println("*** declaracaoArray ***");
        // [] - são inseridos em uma variável que referencia um array
        int[] a = new int[4]; // No new int[] declara-se quantas posições tem o array

        // Outra maneira de fazer uma declaração de array
        int[] b;
        b = new int[10];
        // Declaração de vários arrays
        int[] c = new int[44], d = new int[23];

        // {} - inicializa valores em um array
        int[] iniciaValores = {12,32,54,6,7,8,89,64,64,6};

        // Declara um array de inteiros
        int[] meuArray;

        // Aloca memória para 5 inteiros
        meuArray = new int[5];

        // Inicializa os elementos
        meuArray [0] = 100;
        meuArray [1] = 85;
        meuArray [2] = 12;
        meuArray [3] = 56;
        meuArray [4] = 99;

        System.out.println(meuArray[4]);
        System.out.println(meuArray[1]);

    }

    private static void tamanhoArray() {
        System.out.println("*** tamanhoArray ***");
        int[] arrayUm = {12,3,5,25,6,75,18,98,65,43,2};
        int[] arrayDois = {32,1,5,674,43,66,73,12};

        if (arrayDois.length > 8) {
            System.out.println("Tamanho do ArrayDois - Maior que 8!");
        } else {
            System.out.println("Tamanho do ArrayDois - Menor que 8!");
        }
        System.out.println("\nTamanho do ArrayUm = " + arrayUm.length);
    }

    public static void percorrendoArray() {
        System.out.println("*** percorrendoArray ***");
        int[] arrayUm = {75,54,35,13,1,743,66,22};
        int total = 0;

        // Adiciona o valor de cada elemento ao total
        for (int i : arrayUm) {
            total += i;
        }

        System.out.println("1 - Total de elementos arrayUm: " + total);

    }

    public static void percorrendoArray2() {
        System.out.println("*** percorrendoArray2 ***");
        int[] arrayNum = {75,54,35,13,1,743,66,22};

        //
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.println(arrayNum[i]);
        }

    }

    public static void arrayBidimensional() {
        System.out.println("*** arrayBidimensional ***");
        int[][] array1 = { {1,2,3}, {4,5,6} };
        int[][] array2 = { {1,2}, {3}, {4,5,6} };

        System.out.println("Valores no array1 passados na linha säo:");
        outputArray(array1); // Exibe o array1 por linha

        System.out.println("Valores no array2 passados na linha são:");
        outputArray(array2); // Exibe o array2 por linha
    }

    public static void outputArray(int[][] array) {
        // Faz um loop pelas linhas do array
        for (int linha = 0; linha < array.length; linha++) {
            // Faz um loop pelas colunas da linha atual
            for (int coluna = 0; coluna < array[linha].length; coluna++) {
                System.out.printf("%d ", array[linha][coluna]);
            }
            System.out.println();
        }
    }
}
