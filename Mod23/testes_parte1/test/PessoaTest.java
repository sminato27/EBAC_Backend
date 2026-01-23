import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaTest {

    @Test
    public void testListaSomenteMulheres() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Maria", "F"),
                new Pessoa("João", "M"),
                new Pessoa("Ana", "F"),
                new Pessoa("Joana", "F"),
                new Pessoa("Carlos", "M")
        );

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        Assertions.assertTrue(mulheres.stream().allMatch(p -> p.getSexo().equals("F")), 
                "A lista deve conter apenas pessoas do sexo feminino (F)");
    }
}
