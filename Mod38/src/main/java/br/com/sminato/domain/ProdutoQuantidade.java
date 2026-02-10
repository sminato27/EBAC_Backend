package br.com.sminato.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_qtd_seq")
    @SequenceGenerator(name = "prod_qtd_seq", sequenceName = "sq_produto_quantidade", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    private Produto produto;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    public ProdutoQuantidade() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
}
