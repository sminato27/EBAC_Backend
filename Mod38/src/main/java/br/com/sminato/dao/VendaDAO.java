package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Venda;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    public VendaDAO() {
        super(Venda.class);
    }
}
