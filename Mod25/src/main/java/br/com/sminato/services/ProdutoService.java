
package br.com.sminato.services;

import br.com.sminato.dao.IProdutoDAO;
import br.com.sminato.domain.Produto;
import br.com.sminato.services.generic.GenericService;


public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}