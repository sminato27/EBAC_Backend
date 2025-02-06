package domain;

// Adiciona-se o Comparable para poder usar o Collections.sort().

import java.util.Objects;

/**
 * Comparable: Use-o quando estiver definindo a ordem natural de uma classe e desejar que todos os objetos dessa classe
 * sejam ordenados dessa maneira. Por exemplo, se você está criando uma classe `Produto` e deseja que os produtos sejam
 * ordenados pelo nome por padrão, você implementaria `Comparable` na classe `Produto` e definiria a ordenação pelo nome.
 *
 * Ao trabalhar com a interface Set, o equals e HashCode são obrigatórios.
 */
public class Aluno implements Comparable<Aluno> {

    private String nome;
    private String curso;
    private double nota;
    private String sala;

    public Aluno(String nome, String curso, double nota) {
        this.nome = nome;
        this.curso = curso;
        this.nota = nota;
    }

    public Aluno(String nome, String curso, double nota, String sala) {
        this(nome, curso, nota);
        this.sala = sala;
    }

    /**
     * toString é usado para converter o objeto em String.
     * @return toString
     */
    @Override
    public String toString() {
        return this.nome;
    }

    /**
     * Implementação do Comparable para poder ordenar o objeto Aluno. Nesse caso compara apenas o nome.
     * Você quem decide qual característica do objeto comparar.
     * Só existe a possiblidade de aplicar uma comparação por classe.
     * @param aluno the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Aluno aluno) {
        return this.nome.compareTo(aluno.getNome());
    }

    /**
     * Geração do equals e hashcode para impedir repetição de objetos nas listas.
     * Nesse caso está comparando todos os valores, se algum valor for diferente (nome, curso ou nota), irá repetir.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Double.compare(nota, aluno.nota) == 0 && Objects.equals(nome, aluno.nome) && Objects.equals(curso, aluno.curso) && Objects.equals(sala, aluno.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, curso, nota, sala);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }


}
