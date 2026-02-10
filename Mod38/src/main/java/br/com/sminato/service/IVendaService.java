package br.com.sminato.service;

import br.com.sminato.domain.Venda;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import java.util.Collection;

public interface IVendaService {

    Venda cadastrar(Venda venda) throws ServiceException, DAOException;

    void excluir(Venda venda) throws ServiceException, DAOException;

    Venda alterar(Venda venda) throws ServiceException, DAOException;

    Venda consultar(Long id) throws ServiceException, DAOException;

    Collection<Venda> buscarTodos() throws DAOException;

    void finalizar(Venda venda) throws ServiceException, DAOException;

    void cancelar(Venda venda) throws ServiceException, DAOException;
}
