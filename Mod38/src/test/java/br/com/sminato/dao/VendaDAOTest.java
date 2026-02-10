package br.com.sminato.dao;

import br.com.sminato.domain.Cliente;
import br.com.sminato.domain.Produto;
import br.com.sminato.domain.ProdutoQuantidade;
import br.com.sminato.domain.Status;
import br.com.sminato.domain.Venda;
import br.com.sminato.exceptions.DAOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VendaDAOTest {

    private IVendaDAO vendaDAO;
    private IClienteDAO clienteDAO;
    private IProdutoDAO produtoDAO;

    public VendaDAOTest() {
        vendaDAO = new VendaDAO();
        clienteDAO = new ClienteDAO();
        produtoDAO = new ProdutoDAO();
    }

    @BeforeEach
    public void init() throws DAOException {
        limparDados();
    }

    @AfterEach
    public void end() throws DAOException {
        limparDados();
    }

    private void limparDados() throws DAOException {
        Collection<Venda> list = vendaDAO.buscarTodos();
        for (Venda v : list) {
            vendaDAO.excluir(v);
        }
        
        Collection<Cliente> clientes = clienteDAO.buscarTodos();
        for (Cliente c : clientes) {
            clienteDAO.excluir(c);
        }

        Collection<Produto> produtos = produtoDAO.buscarTodos();
        for (Produto p : produtos) {
            produtoDAO.excluir(p);
        }
    }

    @Test
    public void pesquisar() throws DAOException {
        Venda venda = criarVenda("V1", "12345678901", "P1");
        vendaDAO.cadastrar(venda);

        Venda vendaConsultada = vendaDAO.consultar(venda.getId());
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void salvar() throws DAOException {
        Venda venda = criarVenda("V2", "12345678902", "P2");
        Venda retorno = vendaDAO.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(retorno.getId());
        assertEquals(Status.INICIADA, retorno.getStatus());
    }

    @Test
    public void excluir() throws DAOException {
        Venda venda = criarVenda("V3", "12345678903", "P3");
        vendaDAO.cadastrar(venda);

        Venda vendaConsultada = vendaDAO.consultar(venda.getId());
        assertNotNull(vendaConsultada);

        vendaDAO.excluir(vendaConsultada);
        Venda vendaExcluida = vendaDAO.consultar(venda.getId());
        assertNull(vendaExcluida);
    }

    @Test
    public void alterar() throws DAOException {
        Venda venda = criarVenda("V4", "12345678904", "P4");
        vendaDAO.cadastrar(venda);

        Venda vendaConsultada = vendaDAO.consultar(venda.getId());
        assertNotNull(vendaConsultada);

        vendaConsultada.setCodigo("V4-Alterado");
        vendaDAO.alterar(vendaConsultada);

        Venda vendaAlterada = vendaDAO.consultar(vendaConsultada.getId());
        assertNotNull(vendaAlterada);
        assertEquals("V4-Alterado", vendaAlterada.getCodigo());
    }

    @Test
    public void buscarTodos() throws DAOException {
        Venda v1 = criarVenda("V5", "12345678905", "P5");
        vendaDAO.cadastrar(v1);

        Venda v2 = criarVenda("V6", "12345678906", "P6");
        vendaDAO.cadastrar(v2);

        Collection<Venda> list = vendaDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    private Venda criarVenda(String codigo, String cpf, String codigoProduto) throws DAOException {
        Cliente cliente = criarCliente(cpf);
        Produto produto = criarProduto(codigoProduto);
        
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setCliente(cliente);
        venda.setDataVenda(Instant.now());
        venda.setStatus(Status.INICIADA);
        
        ProdutoQuantidade pq = new ProdutoQuantidade();
        pq.setProduto(produto);
        pq.setQuantidade(2);
        pq.setValorTotal(produto.getValor() * 2);
        
        Set<ProdutoQuantidade> produtos = new HashSet<>();
        produtos.add(pq);
        venda.setProdutos(produtos);
        venda.setValorTotal(pq.getValorTotal());
        
        return venda;
    }

    private Cliente criarCliente(String cpf) throws DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome("Minato");
        cliente.setCidade("Tubarão");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel("9999999999");
        cliente.setEmail("teste@email.com");
        return clienteDAO.cadastrar(cliente);
    }

    private Produto criarProduto(String codigo) throws DAOException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Descricao");
        produto.setNome("Produto 1");
        produto.setValor(10.0);
        return produtoDAO.cadastrar(produto);
    }
}
