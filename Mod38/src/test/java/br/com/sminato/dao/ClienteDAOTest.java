package br.com.sminato.dao;

import br.com.sminato.domain.Cliente;
import br.com.sminato.exceptions.DAOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDAO();
    }

    @BeforeEach
    public void init() throws DAOException {
        Collection<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente c : list) {
            clienteDAO.excluir(c);
        }
    }

    @AfterEach
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente c : list) {
            clienteDAO.excluir(c);
        }
    }

    @Test
    public void pesquisarCliente() throws DAOException {
        Cliente cliente = criarCliente("12345678901");
        clienteDAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getId());
        assertNotNull(clienteConsultado);
        assertEquals(cliente.getCpf(), clienteConsultado.getCpf());
    }

    @Test
    public void salvarCliente() throws DAOException {
        Cliente cliente = criarCliente("12345678902");
        Cliente retorno = clienteDAO.cadastrar(cliente);
        assertNotNull(retorno);
        assertNotNull(retorno.getId());
    }

    @Test
    public void excluirCliente() throws DAOException {
        Cliente cliente = criarCliente("12345678903");
        clienteDAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteDAO.excluir(clienteConsultado);
        Cliente clienteExcluido = clienteDAO.consultar(cliente.getId());
        assertNull(clienteExcluido);
    }

    @Test
    public void alterarCliente() throws DAOException {
        Cliente cliente = criarCliente("12345678904");
        clienteDAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Minato Sahashi");
        clienteDAO.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDAO.consultar(clienteConsultado.getId());
        assertNotNull(clienteAlterado);
        assertEquals("Minato Sahashi", clienteAlterado.getNome());
    }

    @Test
    public void buscarTodos() throws DAOException {
        Cliente cliente1 = criarCliente("12345678905");
        clienteDAO.cadastrar(cliente1);

        Cliente cliente2 = criarCliente("12345678906");
        clienteDAO.cadastrar(cliente2);

        Collection<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertTrue(list.size() >= 2);
    }

    private Cliente criarCliente(String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome("Minato");
        cliente.setCidade("Tubarão");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel("9999999999");
        cliente.setEmail("teste@email.com");
        return cliente;
    }
}
