package br.com.sminato.mod40.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
    @SequenceGenerator(name = "produto_sequence", sequenceName = "produto_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Valor", nullable = false, length = 10)
    private Double valor;

    @Column(name = "Descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "Codigo", nullable = false, length = 10)
    private String codigo;
}
