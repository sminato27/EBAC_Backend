public class App {
    public static void main(String[] args) {

        Estoque<Volkswagen> estoqueVolkswagen;
        estoqueVolkswagen = new Estoque<>();

        estoqueVolkswagen.adicionar(new Volkswagen("Polo", 35000.5));

        Estoque<Fiat> estoqueFiat;
        estoqueFiat = new Estoque<>();

        estoqueFiat.adicionar(new Fiat("Uno", 23000.8));

        Estoque<Honda> estoqueHonda;
        estoqueHonda = new Estoque<>();

        estoqueHonda.adicionar(new Honda("Civic", 45000.2));

        System.out.println("Exibição estoque Volkswagen:");
        UtilEstoque.exibirEstoque(estoqueVolkswagen.getCatalogoCarros());

        System.out.println("\nExibição estoque Fiat:");
        UtilEstoque.exibirEstoque(estoqueFiat.getCatalogoCarros());

        System.out.println("\nExibição estoque Honda:");
        UtilEstoque.exibirEstoque(estoqueHonda.getCatalogoCarros());





    }
}
