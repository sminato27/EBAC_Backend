package br.com.sminato.controller;

import br.com.sminato.domain.Cliente;
import br.com.sminato.domain.Produto;
import br.com.sminato.domain.ProdutoQuantidade;
import br.com.sminato.domain.Status;
import br.com.sminato.domain.Venda;
import br.com.sminato.service.IClienteService;
import br.com.sminato.service.IProdutoService;
import br.com.sminato.service.IVendaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class VendaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IVendaService vendaService;

    @Inject
    private IClienteService clienteService;

    @Inject
    private IProdutoService produtoService;

    private Venda venda;
    private Collection<Venda> vendas;
    private Boolean isUpdate;
    private Date dataVenda;
    private Produto produtoSelecionado;
    private Integer quantidadeProduto;
    private List<ProdutoQuantidade> produtos;
    private Double valorTotal;

    @PostConstruct
    public void init() {
        try {
            this.venda = new Venda();
            this.vendas = vendaService.buscarTodos();
            this.isUpdate = false;
            this.produtos = new ArrayList<>();
            this.valorTotal = 0.0;
            this.quantidadeProduto = 1;
            this.dataVenda = new Date();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao carregar vendas"));
        }
    }

    public List<Cliente> filtrarClientes(String query) {
        try {
            return clienteService.buscarTodos().stream()
                    .filter(c -> c.getNome().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Produto> filtrarProdutos(String query) {
        try {
            return produtoService.buscarTodos().stream()
                    .filter(p -> p.getNome().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void adicionarProduto() {
        if (produtoSelecionado != null && quantidadeProduto != null && quantidadeProduto > 0) {
            ProdutoQuantidade jaExiste = produtos.stream()
                    .filter(p -> p.getProduto().getId().equals(produtoSelecionado.getId()))
                    .findFirst().orElse(null);

            if (jaExiste != null) {
                jaExiste.setQuantidade(jaExiste.getQuantidade() + quantidadeProduto);
                jaExiste.setValorTotal(jaExiste.getQuantidade() * jaExiste.getProduto().getValor());
            } else {
                ProdutoQuantidade pq = new ProdutoQuantidade();
                pq.setProduto(produtoSelecionado);
                pq.setQuantidade(quantidadeProduto);
                pq.setValorTotal(produtoSelecionado.getValor() * quantidadeProduto);
                produtos.add(pq);
            }
            recalcularTotal();
            produtoSelecionado = null;
            quantidadeProduto = 1;
        }
    }

    public void removerProduto() {
        if (produtoSelecionado != null) {
            produtos.removeIf(p -> p.getProduto().getId().equals(produtoSelecionado.getId()));
            recalcularTotal();
        }
    }

    public void removerProduto(ProdutoQuantidade pq) {
        produtos.remove(pq);
        recalcularTotal();
    }

    private void recalcularTotal() {
        this.valorTotal = produtos.stream()
                .mapToDouble(ProdutoQuantidade::getValorTotal)
                .sum();
    }

    public void add() {
        try {
            venda.setProdutos(new HashSet<>(produtos));
            venda.setValorTotal(valorTotal);
            if (dataVenda != null) {
                venda.setDataVenda(dataVenda.toInstant());
            }
            venda.setStatus(Status.INICIADA);
            vendaService.cadastrar(venda);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Venda cadastrada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void update() {
        try {
            venda.setProdutos(new HashSet<>(produtos));
            venda.setValorTotal(valorTotal);
            if (dataVenda != null) {
                venda.setDataVenda(dataVenda.toInstant());
            }
            vendaService.alterar(venda);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Venda atualizada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void cancel() {
        this.venda = new Venda();
        this.isUpdate = false;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.dataVenda = new Date();
        this.quantidadeProduto = 1;
        this.produtoSelecionado = null;
    }

    public void edit(Venda v) {
        this.venda = v;
        this.dataVenda = Date.from(v.getDataVenda().atZone(ZoneId.systemDefault()).toInstant());
        this.produtos = new ArrayList<>(v.getProdutos());
        this.valorTotal = v.getValorTotal();
        this.isUpdate = true;
    }

    public void delete(Venda v) {
        try {
            vendaService.cancelar(v);
            this.vendas = vendaService.buscarTodos();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Venda cancelada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao cancelar venda"));
        }
    }

    public void finalizar(Venda v) {
        try {
            vendaService.finalizar(v);
            this.vendas = vendaService.buscarTodos();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Venda finalizada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao finalizar venda"));
        }
    }

    public String voltarTelaInicial() {
        return "/index.xhtml?faces-redirect=true";
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Collection<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Collection<Venda> vendas) {
        this.vendas = vendas;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public List<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoQuantidade> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
