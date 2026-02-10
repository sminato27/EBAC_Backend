package br.com.sminato.service;

import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import java.util.Collection;

public interface IClienteService {

    Cliente cadastrar(Cliente cliente) throws ServiceException, DAOException;

    void excluir(Cliente cliente) throws ServiceException, DAOException;

    Cliente alterar(Cliente cliente) throws ServiceException, DAOException;

    Cliente consultar(Long id) throws ServiceException, DAOException;

    Collection<Cliente> buscarTodos() throws DAOException;
}
