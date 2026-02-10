package br.com.sminato.controller;

import br.com.sminato.domain.Produto;
import br.com.sminato.service.IProdutoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IProdutoService produtoService;

    private Produto produto;
    private Collection<Produto> produtos;
    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.produto = new Produto();
            this.produtos = produtoService.buscarTodos();
            this.isUpdate = false;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao carregar produtos"));
        }
    }

    public void add() {
        try {
            produtoService.cadastrar(produto);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto cadastrado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void update() {
        try {
            produtoService.alterar(produto);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void cancel() {
        this.produto = new Produto();
        this.isUpdate = false;
    }

    public void edit(Produto prod) {
        this.produto = prod;
        this.isUpdate = true;
    }

    public void delete(Produto prod) {
        try {
            produtoService.excluir(prod);
            this.produtos = produtoService.buscarTodos();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto removido com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao remover produto"));
        }
    }

    public String voltarTelaInicial() {
        return "/index.xhtml?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}
