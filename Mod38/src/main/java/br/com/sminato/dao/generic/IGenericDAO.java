package br.com.sminato.dao.generic;

import br.com.sminato.exceptions.DAOException;
import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Serializable, ID extends Serializable> {

    T cadastrar(T entity) throws DAOException;

    void excluir(T entity) throws DAOException;

    T alterar(T entity) throws DAOException;

    T consultar(ID id) throws DAOException;

    Collection<T> buscarTodos() throws DAOException;
}
