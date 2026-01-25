
package br.com.sminato.services;

import br.com.sminato.dao.IClienteDAO;
import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;
import br.com.sminato.services.generic.GenericService;


public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	

	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);

	}






	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}











}