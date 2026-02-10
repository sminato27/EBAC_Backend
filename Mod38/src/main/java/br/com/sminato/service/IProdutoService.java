package br.com.sminato.service;

import br.com.sminato.domain.Produto;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import java.util.Collection;

public interface IProdutoService {

    Produto cadastrar(Produto produto) throws ServiceException, DAOException;

    void excluir(Produto produto) throws ServiceException, DAOException;

    Produto alterar(Produto produto) throws ServiceException, DAOException;

    Produto consultar(Long id) throws ServiceException, DAOException;

    Collection<Produto> buscarTodos() throws DAOException;
}
