package test.java.br.com.sminato;

import main.java.br.com.sminato.dao.IProdutoDAO;
import main.java.br.com.sminato.dao.ProdutoDAO;
import main.java.br.com.sminato.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    @After
    public void end() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        List<Produto> list = dao.buscarTodos();
        for (Produto prod : list) {
            dao.excluir(prod);
        }
    }

    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB = dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertNotNull(produtoDB.getId());
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer qtdDel = dao.excluir(produtoDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB = dao.consultar("01");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer qtdDel = dao.excluir(produtoDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void excluirTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB = dao.consultar("01");
        assertNotNull(produtoDB);

        Integer qtdDel = dao.excluir(produtoDB);
        assertTrue(qtdDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado");
        dao.cadastrar(produto);

        Produto produto2 = new Produto();
        produto2.setCodigo("02");
        produto2.setNome("Mouse");
        dao.cadastrar(produto2);

        List<Produto> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Produto prod : list) {
            dao.excluir(prod);
        }
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado");
        dao.cadastrar(produto);

        Produto produtoDB = dao.consultar("01");
        assertNotNull(produtoDB);
        produtoDB.setCodigo("20");
        produtoDB.setNome("Monitor");
        Integer qtdAlt = dao.update(produtoDB);
        assertTrue(qtdAlt == 1);

        Produto produtoAlt = dao.consultar("01");
        assertNull(produtoAlt);

        Produto produtoAlt2 = dao.consultar("20");
        assertNotNull(produtoAlt2);
        assertEquals("20", produtoAlt2.getCodigo());
        assertEquals("Monitor", produtoAlt2.getNome());

        dao.excluir(produtoAlt2);
    }
}
