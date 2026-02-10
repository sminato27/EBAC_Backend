package br.com.sminato.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "TEL", nullable = false, length = 15)
    private String tel;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "ENDERECO", nullable = false, length = 100)
    private String end;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
