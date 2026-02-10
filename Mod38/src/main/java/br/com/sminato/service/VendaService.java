package br.com.sminato.service;

import br.com.sminato.dao.IVendaDAO;
import br.com.sminato.domain.ProdutoQuantidade;
import br.com.sminato.domain.Status;
import br.com.sminato.domain.Venda;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class VendaService implements IVendaService {

    @Inject
    private IVendaDAO vendaDAO;

    @Override
    public Venda cadastrar(Venda venda) throws ServiceException, DAOException {
        venda.setStatus(Status.INICIADA);
        validarVenda(venda);
        return vendaDAO.cadastrar(venda);
    }

    @Override
    public void excluir(Venda venda) throws ServiceException, DAOException {
        vendaDAO.excluir(venda);
    }

    @Override
    public Venda alterar(Venda venda) throws ServiceException, DAOException {
        if (venda.getStatus() != Status.INICIADA) {
            throw new ServiceException("Apenas vendas INICIADAS podem ser alteradas");
        }
        validarVenda(venda);
        return vendaDAO.alterar(venda);
    }

    @Override
    public Venda consultar(Long id) throws ServiceException, DAOException {
        return vendaDAO.consultar(id);
    }

    @Override
    public Collection<Venda> buscarTodos() throws DAOException {
        return vendaDAO.buscarTodos();
    }

    @Override
    public void finalizar(Venda venda) throws ServiceException, DAOException {
        if (venda.getStatus() != Status.INICIADA) {
            throw new ServiceException("Apenas vendas INICIADAS podem ser finalizadas");
        }
        venda.setStatus(Status.CONCLUIDA);
        vendaDAO.alterar(venda);
    }

    @Override
    public void cancelar(Venda venda) throws ServiceException, DAOException {
        if (venda.getStatus() != Status.INICIADA) {
            throw new ServiceException("Apenas vendas INICIADAS podem ser canceladas");
        }
        venda.setStatus(Status.CANCELADA);
        vendaDAO.alterar(venda);
    }

    private void validarVenda(Venda venda) throws ServiceException {
        if (venda.getCodigo() == null || venda.getCodigo().trim().isEmpty()) {
            throw new ServiceException("Código é obrigatório");
        }
        if (venda.getCliente() == null) {
            throw new ServiceException("Cliente é obrigatório");
        }
        if (venda.getDataVenda() == null) {
            throw new ServiceException("Data da venda é obrigatória");
        }
        if (venda.getProdutos() == null || venda.getProdutos().isEmpty()) {
            throw new ServiceException("A venda deve ter pelo menos um produto");
        }

        Double valorTotalCalculado = 0.0;
        for (ProdutoQuantidade pq : venda.getProdutos()) {
            if (pq.getProduto() == null) {
                throw new ServiceException("Cada item deve ter um produto associado");
            }
            if (pq.getQuantidade() == null || pq.getQuantidade() <= 0) {
                throw new ServiceException("Quantidade deve ser maior que zero");
            }
            Double valorItem = pq.getProduto().getValor() * pq.getQuantidade();
            if (Math.abs(pq.getValorTotal() - valorItem) > 0.01) {
                throw new ServiceException("Valor total do item inconsistente para o produto: " + pq.getProduto().getNome());
            }
            valorTotalCalculado += pq.getValorTotal();
        }

        if (Math.abs(venda.getValorTotal() - valorTotalCalculado) > 0.01) {
            throw new ServiceException("Valor total da venda inconsistente com a soma dos itens");
        }
    }
}
