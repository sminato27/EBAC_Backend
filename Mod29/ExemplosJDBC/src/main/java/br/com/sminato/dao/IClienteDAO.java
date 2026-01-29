package main.java.br.com.sminato.dao;

import main.java.br.com.sminato.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    Cliente consultar(String codigo) throws Exception;

    Integer excluir(Cliente clienteDB) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Integer update(Cliente cliente) throws Exception;
}
