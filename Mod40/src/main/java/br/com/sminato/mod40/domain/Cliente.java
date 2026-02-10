package br.com.sminato.mod40.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    @SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private Long cpf;

    @Column(name = "Tel", nullable = false, length = 11)
    private Long telefone;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Endereco", nullable = false, length = 100)
    private String endereco;

    @Column(name = "Numero", nullable = true)
    private Integer numero;

    @Column(name = "Cidade", nullable = false, length = 50)
    private String cidade;

    @Column(name = "Estado", nullable = false, length = 2)
    private String estado;
}
