package br.com.sminato.controller;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = 1L;

    public String redirectCliente() {
        return "/cliente/list.xhtml?faces-redirect=true";
    }

    public String redirectProduto() {
        return "/produto/list.xhtml?faces-redirect=true";
    }

    public String redirectVenda() {
        return "/venda/list.xhtml?faces-redirect=true";
    }
}
