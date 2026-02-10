package br.com.sminato.service;

import br.com.sminato.dao.IClienteDAO;
import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ClienteService implements IClienteService {

    @Inject
    private IClienteDAO clienteDAO;

    @Override
    public Cliente cadastrar(Cliente cliente) throws ServiceException, DAOException {
        validarCliente(cliente);
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public void excluir(Cliente cliente) throws ServiceException, DAOException {
        clienteDAO.excluir(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) throws ServiceException, DAOException {
        validarCliente(cliente);
        return clienteDAO.alterar(cliente);
    }

    @Override
    public Cliente consultar(Long id) throws ServiceException, DAOException {
        return clienteDAO.consultar(id);
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return clienteDAO.buscarTodos();
    }

    private void validarCliente(Cliente cliente) throws ServiceException {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new ServiceException("Nome é obrigatório");
        }
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new ServiceException("CPF é obrigatório");
        }
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@")) {
            throw new ServiceException("Email inválido");
        }
    }
}
