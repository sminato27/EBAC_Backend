package br.com.sminato.dao;

import br.com.sminato.domain.Produto;
import br.com.sminato.exceptions.DAOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    public ProdutoDAOTest() {
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
        Collection<Produto> list = produtoDAO.buscarTodos();
        for (Produto p : list) {
            produtoDAO.excluir(p);
        }
    }

    @Test
    public void pesquisar() throws DAOException {
        Produto produto = criarProduto("A1");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar(produto.getId());
        assertNotNull(produtoConsultado);
        assertEquals(produto.getCodigo(), produtoConsultado.getCodigo());
    }

    @Test
    public void salvar() throws DAOException {
        Produto produto = criarProduto("A2");
        Produto retorno = produtoDAO.cadastrar(produto);
        assertNotNull(retorno);
        assertNotNull(retorno.getId());
    }

    @Test
    public void excluir() throws DAOException {
        Produto produto = criarProduto("A3");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar(produto.getId());
        assertNotNull(produtoConsultado);

        produtoDAO.excluir(produtoConsultado);
        Produto produtoExcluido = produtoDAO.consultar(produto.getId());
        assertNull(produtoExcluido);
    }

    @Test
    public void alterar() throws DAOException {
        Produto produto = criarProduto("A4");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar(produto.getId());
        assertNotNull(produtoConsultado);

        produtoConsultado.setNome("Produto Alterado");
        produtoDAO.alterar(produtoConsultado);

        Produto produtoAlterado = produtoDAO.consultar(produtoConsultado.getId());
        assertNotNull(produtoAlterado);
        assertEquals("Produto Alterado", produtoAlterado.getNome());
    }

    @Test
    public void buscarTodos() throws DAOException {
        Produto p1 = criarProduto("A5");
        produtoDAO.cadastrar(p1);

        Produto p2 = criarProduto("A6");
        produtoDAO.cadastrar(p2);

        Collection<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    private Produto criarProduto(String codigo) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Descricao do produto");
        produto.setNome("Produto 1");
        produto.setValor(10.0);
        return produto;
    }
}
