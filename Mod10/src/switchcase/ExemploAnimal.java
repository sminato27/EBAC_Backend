package switchcase;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExemploAnimal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o nome de um animal: ");
        String texto = s.next();
        String animal = exampleOfSwitch(texto);
        System.out.println(animal);

    }

    public static String exampleOfSwitch(String animal) {
        String result;
        switch (animal) {
            case "Cachorro":
            case "Gato":
                result = "Animal doméstico.";
                break;
            case "Tigre":
                result = "Animal selvagem.";
                break;
            default:
                result = "Animal desconhecido.";
                break;
        }
        return result;
    }
}
