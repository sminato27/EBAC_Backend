package br.com.sminato;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.sminato.dao.IClienteDAO;
import br.com.sminato.dao.ClienteDaoMock;
import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;
import br.com.sminato.services.ClienteService;
import br.com.sminato.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Minato");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Minato Sahashi");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Minato Sahashi", cliente.getNome());
	}
}
