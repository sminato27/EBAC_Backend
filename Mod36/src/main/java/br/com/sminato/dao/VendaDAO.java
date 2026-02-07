package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Venda;
import br.com.sminato.domain.Venda.Status;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

	public VendaDAO() {
		super("Postgres1");
	}

	public VendaDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}

	@Override
	public String getNomeCampoChave() {
		return "codigo";
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		try {
			entityManager.getTransaction().begin();
			venda.setStatus(Status.CONCLUIDA);
			entityManager.merge(venda);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
			throw new DAOException("Erro ao finalizar venda", e);
		} finally {
			closeConnection();
		}
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		try {
			entityManager.getTransaction().begin();
			venda.setStatus(Status.CANCELADA);
			entityManager.merge(venda);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
			throw new DAOException("Erro ao cancelar venda", e);
		} finally {
			closeConnection();
		}
	}

}
