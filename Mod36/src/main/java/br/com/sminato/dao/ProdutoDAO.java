package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {
	
	public ProdutoDAO() {
		super("Postgres1");
	}

	public ProdutoDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	@Override
	public Class<Produto> getTipoClasse() {
		return Produto.class;
	}

	@Override
	public void atualiarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setValor(entity.getValor());
	}

	@Override
	public String getNomeCampoChave() {
		return "codigo";
	}

}
