package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }
}
