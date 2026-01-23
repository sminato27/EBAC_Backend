import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes e sexos no formato Nome-Sexo, separados por vírgula (ex: Maria-F,João-M,Ana-F):");

        String input = scanner.nextLine();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("Entrada vazia.");
            return;
        }

        List<String> itens = Arrays.asList(input.split(","));

        List<Pessoa> pessoas = itens.stream()
                .map(item -> {
                    String[] dados = item.trim().split("-");
                    if (dados.length == 2) {
                        String nome = dados[0].trim();
                        String sexo = dados[1].trim().toUpperCase();

                        // Utilizando if/else para validar o sexo
                        if (sexo.equals("M") || sexo.equals("F")) {
                            return new Pessoa(nome, sexo);
                        } else {
                            System.out.println("Sexo inválido para " + nome + ": " + sexo + ". Ignorando registro.");
                            return null;
                        }
                    }
                    return null;
                })
                .filter(p -> p != null)
                .collect(Collectors.toList());

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        System.out.println("\nNomes das mulheres encontradas:");
        if (mulheres.isEmpty()) {
            System.out.println("Nenhuma mulher na lista.");
        } else {
            mulheres.forEach(mulher -> System.out.println(mulher.getNome()));
        }

        scanner.close();
    }
}

class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', sexo='" + sexo + "'}";
    }
}