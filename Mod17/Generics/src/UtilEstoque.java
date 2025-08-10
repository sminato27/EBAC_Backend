import java.util.List;

public class UtilEstoque {

    public static void exibirEstoque(List<? extends Carros> listaCarros) {
        for (Carros c : listaCarros) {
            System.out.println(c);
        }
    }

}
