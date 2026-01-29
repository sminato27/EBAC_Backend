package main.java.br.com.sminato.dao;

import main.java.br.com.sminato.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    Produto consultar(String codigo) throws Exception;

    Integer excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Integer update(Produto produto) throws Exception;
}
