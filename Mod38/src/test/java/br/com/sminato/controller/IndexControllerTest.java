package br.com.sminato.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IndexControllerTest {

    @Test
    public void testRedirectCliente() {
        IndexController controller = new IndexController();
        assertEquals("/cliente/list.xhtml?faces-redirect=true", controller.redirectCliente());
    }

    @Test
    public void testRedirectProduto() {
        IndexController controller = new IndexController();
        assertEquals("/produto/list.xhtml?faces-redirect=true", controller.redirectProduto());
    }

    @Test
    public void testRedirectVenda() {
        IndexController controller = new IndexController();
        assertEquals("/venda/list.xhtml?faces-redirect=true", controller.redirectVenda());
    }
}
