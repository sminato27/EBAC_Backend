package br.com.sminato.service;

import br.com.sminato.dao.IProdutoDAO;
import br.com.sminato.domain.Produto;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.ServiceException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProdutoService implements IProdutoService {

    @Inject
    private IProdutoDAO produtoDAO;

    @Override
    public Produto cadastrar(Produto produto) throws ServiceException, DAOException {
        validarProduto(produto);
        return produtoDAO.cadastrar(produto);
    }

    @Override
    public void excluir(Produto produto) throws ServiceException, DAOException {
        produtoDAO.excluir(produto);
    }

    @Override
    public Produto alterar(Produto produto) throws ServiceException, DAOException {
        validarProduto(produto);
        return produtoDAO.alterar(produto);
    }

    @Override
    public Produto consultar(Long id) throws ServiceException, DAOException {
        return produtoDAO.consultar(id);
    }

    @Override
    public Collection<Produto> buscarTodos() throws DAOException {
        return produtoDAO.buscarTodos();
    }

    private void validarProduto(Produto produto) throws ServiceException {
        if (produto.getCodigo() == null || produto.getCodigo().trim().isEmpty()) {
            throw new ServiceException("Código é obrigatório");
        }
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new ServiceException("Nome é obrigatório");
        }
        if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
            throw new ServiceException("Descrição é obrigatória");
        }
        if (produto.getValor() == null || produto.getValor() <= 0) {
            throw new ServiceException("Valor deve ser maior que zero");
        }
    }
}
