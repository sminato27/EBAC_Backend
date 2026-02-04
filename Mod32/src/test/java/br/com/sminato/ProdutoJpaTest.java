package br.com.sminato;

import br.com.sminato.dao.IProdutoDao;
import br.com.sminato.dao.ProdutoDao;
import br.com.sminato.domain.Produto;
import br.com.sminato.jpa.JPAUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ProdutoJpaTest {

    private IProdutoDao produtoDao = new ProdutoDao();

    @AfterAll
    public static void tearDown() {
        JPAUtil.close();
    }

    @Test
    public void testTableCreation() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Verifica se a tabela existe no PostgreSQL
            Query query = em.createNativeQuery(
                "SELECT count(*) FROM information_schema.tables WHERE table_name = 'tb_produto'"
            );
            BigInteger count = (BigInteger) query.getSingleResult();
            Assertions.assertEquals(BigInteger.ONE, count, "A tabela tb_produto deveria ter sido criada.");
        } finally {
            em.close();
        }
    }

    @Test
    public void testCadastrarProduto() {
        Produto produto = new Produto();
        produto.setNome("Teclado Mecânico");
        produto.setPreco(new BigDecimal("350.00"));
        produto.setQuantidade(10);

        produto = produtoDao.cadastrar(produto);

        Assertions.assertNotNull(produto.getId());
        
        Produto produtoConsultado = produtoDao.buscarPorId(produto.getId());
        Assertions.assertNotNull(produtoConsultado);
        Assertions.assertEquals(produto.getNome(), produtoConsultado.getNome());
    }
}
