
package br.com.sminato.services;

import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;


public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}