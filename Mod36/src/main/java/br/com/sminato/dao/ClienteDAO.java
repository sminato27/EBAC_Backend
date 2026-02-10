package br.com.sminato.dao;

import br.com.sminato.dao.generic.GenericDAO;
import br.com.sminato.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super("Postgres1");
	}

	public ClienteDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
	}

	@Override
	public String getNomeCampoChave() {
		return "cpf";
	}

}
