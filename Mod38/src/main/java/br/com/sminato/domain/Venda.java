package br.com.sminato.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "sq_venda", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProdutoQuantidade> produtos;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant dataVenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status;

    public Venda() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Set<ProdutoQuantidade> getProdutos() { return produtos; }
    public void setProdutos(Set<ProdutoQuantidade> produtos) { this.produtos = produtos; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public Instant getDataVenda() { return dataVenda; }
    public void setDataVenda(Instant dataVenda) { this.dataVenda = dataVenda; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
