public class Exemplo1 {
    public static void main(String[] args) {

        // Autoboxing (quando se atribui um valor primitivo no tipo wrapper).
        Boolean status = true;
        // (Sem autoboxing) Valor wrapper da variável wrapper:
        Boolean status1 = Boolean.TRUE;

        // Unboxing (quando converte-se o valor de um objeto wrapper para o tipo primitivo).
        boolean status2 = Boolean.TRUE;
        char letra = Character.valueOf('A');
    }
}
