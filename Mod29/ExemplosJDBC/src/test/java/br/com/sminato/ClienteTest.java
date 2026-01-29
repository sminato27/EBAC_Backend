package test.java.br.com.sminato;

import main.java.br.com.sminato.dao.ClienteDAO;
import main.java.br.com.sminato.dao.IClienteDAO;
import main.java.br.com.sminato.domain.Cliente;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    @After
    public void end() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        List<Cliente> list = dao.buscarTodos();
        for (Cliente cli : list) {
            dao.excluir(cli);
        }
    }

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Minato");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteDB = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteDB);
        assertNotNull(clienteDB.getId());
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        Integer qtdDel = dao.excluir(clienteDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Minato");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteDB = dao.consultar("01");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        Integer qtdDel = dao.excluir(clienteDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void excluirTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Minato");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteDB = dao.consultar("01");
        assertNotNull(clienteDB);

        Integer qtdDel = dao.excluir(clienteDB);
        assertTrue(qtdDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Minato");
        dao.cadastrar(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Elisangela");
        dao.cadastrar(cliente2);

        List<Cliente> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Cliente cli : list) {
            dao.excluir(cli);
        }
    }

    @Test
    public void atualizarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Minato");
        dao.cadastrar(cliente);

        Cliente clienteDB = dao.consultar("01");
        assertNotNull(clienteDB);
        clienteDB.setCodigo("20");
        clienteDB.setNome("Elisangela");
        Integer qtdAlt = dao.update(clienteDB);
        assertTrue(qtdAlt == 1);

        Cliente clienteAlt = dao.consultar("01");
        assertNull(clienteAlt);

        Cliente clienteAlt2 = dao.consultar("20");
        assertNotNull(clienteAlt2);
        assertEquals("20", clienteAlt2.getCodigo());
        assertEquals("Elisangela", clienteAlt2.getNome());

        dao.excluir(clienteAlt2);
    }
}
