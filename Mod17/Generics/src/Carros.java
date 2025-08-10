public abstract class Carros {
    private String modelo;
    private Double preco;

    public Carros(String modelo, Double preco) {
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return modelo + " - R$" + preco;
    }
}
