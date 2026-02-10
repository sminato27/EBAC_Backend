package br.com.sminato.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @SequenceGenerator(name = "prod_seq", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", nullable = false, length = 10, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    public Produto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}
