package br.com.sminato.controller;

import br.com.sminato.domain.Cliente;
import br.com.sminato.service.IClienteService;
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
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IClienteService clienteService;

    private Cliente cliente;
    private Collection<Cliente> clientes;
    private Boolean isUpdate;
    private String cpfMask;
    private String telMask;

    @PostConstruct
    public void init() {
        try {
            this.cliente = new Cliente();
            this.clientes = clienteService.buscarTodos();
            this.isUpdate = false;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao carregar clientes"));
        }
    }

    public void add() {
        try {
            cliente.setCpf(cpfMask.replaceAll("[^0-9]", ""));
            cliente.setTel(telMask.replaceAll("[^0-9]", ""));
            clienteService.cadastrar(cliente);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente cadastrado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void update() {
        try {
            cliente.setCpf(cpfMask.replaceAll("[^0-9]", ""));
            cliente.setTel(telMask.replaceAll("[^0-9]", ""));
            clienteService.alterar(cliente);
            init();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void cancel() {
        this.cliente = new Cliente();
        this.isUpdate = false;
        this.cpfMask = "";
        this.telMask = "";
    }

    public void edit(Cliente customer) {
        this.cliente = customer;
        this.cpfMask = customer.getCpf();
        this.telMask = customer.getTel();
        this.isUpdate = true;
    }

    public void delete(Cliente customer) {
        try {
            clienteService.excluir(customer);
            this.clientes = clienteService.buscarTodos();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente removido com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao remover cliente"));
        }
    }

    public String voltarTelaInicial() {
        return "/index.xhtml?faces-redirect=true";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getCpfMask() {
        return cpfMask;
    }

    public void setCpfMask(String cpfMask) {
        this.cpfMask = cpfMask;
    }

    public String getTelMask() {
        return telMask;
    }

    public void setTelMask(String telMask) {
        this.telMask = telMask;
    }
}
