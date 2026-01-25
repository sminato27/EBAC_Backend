
package br.com.sminato.dao;

import br.com.sminato.dao.generic.IGenericDAO;
import br.com.sminato.domain.Venda;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;


public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}