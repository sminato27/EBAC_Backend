package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public interface IContratoDao {
    void salvar();

    String buscar();

    String excluir();

    String atualizar();
}
