import java.util.ArrayList;
import java.util.List;

public class Estoque<T extends Carros>  {

    private List<T> catalogoCarros = new ArrayList<>();

    public void adicionar(T carro) {
        catalogoCarros.add(carro);
    }

    public List<T> getCatalogoCarros() {
        return catalogoCarros;
    }
}
