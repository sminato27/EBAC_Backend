public class Exemplo2 {
    public static void main(String[] args) {

        //Casting explícito (quando você quer converter o tipo ao nível de armazenamento (bits)).
        // Nesse caso normalmente é feito quando você tenta colocar um valor maior numa variável que cabe um valor menor.
        int num1 = 10;
        short num2 = (short) num1;


        //Casting implícito (quando você quer converter o tipo de variável de um valor menor para maior(bits)).
        int idade = 10;
        long idadeL = idade;
    }
}
