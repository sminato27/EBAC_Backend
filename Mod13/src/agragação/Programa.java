package agragação;

public class Programa {
    public static void main(String[] args) {
        Produto produtoTV =  criarProduto(1L, 10d, "TV");
        Produto produtoCel =  criarProduto(2L, 105d, "Celular");

        Vendedor vendedor = criarVendedor("Guilherme", 10d);

        Comprador comprador = criarComprador("Jorge", 300d);

        Venda venda = new Venda();
        venda.setVendedor(vendedor);
        venda.setComprador(comprador);
        venda.add(produtoTV);
        venda.add(produtoCel);


        venda.concretizarVenda();
        System.out.println(venda);
        venda.cancelarVenda();
        venda = null;
        System.out.println(venda);
        System.out.println(produtoCel.getNome());


    }

    private static Comprador criarComprador(String nome, double verba) {
        return new Comprador(nome, verba);
    }

    private static Vendedor criarVendedor(String nome, double comissao) {
        Vendedor vendedor = new Vendedor();
        vendedor.setComissao(comissao);
        vendedor.setNome(nome);
        return vendedor;
    }

    private static Produto criarProduto(Long codigo, Double valor, String nome) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setPreco(valor);
        produto.setNome(nome);
        return produto;
    }
}
