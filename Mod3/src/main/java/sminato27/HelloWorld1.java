package sminato27;

public class HelloWorld1 {

    public static void main(String[] args) {
        String ambiente = args[0];
            if (ambiente.equals("DEV")) {
                System.out.println("Executando em DEV");
            } else if (ambiente.equals("TEST")) {
                System.out.println("Executando em TEST");
            } else {
                System.out.println(ambiente);
            }
    }
}