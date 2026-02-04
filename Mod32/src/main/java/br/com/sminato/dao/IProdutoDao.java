package br.com.sminato.dao;

import br.com.sminato.domain.Produto;

public interface IProdutoDao {

    Produto cadastrar(Produto produto);
    Produto buscarPorId(Long id);
}
