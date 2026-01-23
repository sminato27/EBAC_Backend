package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        return contratoDao.buscar();
    }

    @Override
    public String excluir() {
        return contratoDao.excluir();
    }

    @Override
    public String atualizar() {
        return contratoDao.atualizar();
    }
}
