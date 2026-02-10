package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }
}
