package br.com.sminato.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sminato.dao.Persistente;
import br.com.sminato.exceptions.DAOException;
import br.com.sminato.exceptions.MaisDeUmRegistroException;
import br.com.sminato.exceptions.TableException;
import br.com.sminato.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {

    protected String persistenceUnitName;
    private static Map<String, EntityManagerFactory> factories = new HashMap<>();

    protected EntityManager entityManager;

    public GenericDAO(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public abstract Class<T> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);

    public abstract String getNomeCampoChave();

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            throw new DAOException("Erro ao cadastrar", e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void excluir(E valor) throws DAOException {
        openConnection();
        try {
            entityManager.getTransaction().begin();
            T entity = buscarPorChave(valor);
            if (entity != null) entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            throw new DAOException("Erro ao excluir", e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            throw new DAOException("Erro ao alterar", e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        openConnection();
        T entity = buscarPorChave(valor);
        closeConnection();
        return entity;
    }

    private T buscarPorChave(E valor) {
        List<T> list = entityManager.createQuery("SELECT obj FROM " + getTipoClasse().getSimpleName() + " obj WHERE obj." + getNomeCampoChave() + " = :valor", getTipoClasse())
                .setParameter("valor", valor)
                .getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        openConnection();
        List<T> list = entityManager.createQuery(getSelectSql(), getTipoClasse()).getResultList();
        closeConnection();
        return list;
    }

    protected void openConnection() {
        entityManager = getFactory(persistenceUnitName).createEntityManager();
    }

    public static EntityManagerFactory getFactory(String persistenceUnitName) {
        if (!factories.containsKey(persistenceUnitName)) {
            factories.put(persistenceUnitName, Persistence.createEntityManagerFactory(persistenceUnitName));
        }
        return factories.get(persistenceUnitName);
    }

    protected void closeConnection() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void closeFactory() {
        for (EntityManagerFactory factory : factories.values()) {
            if (factory.isOpen()) {
                factory.close();
            }
        }
        factories.clear();
    }

    private String getSelectSql() {
        return "SELECT obj FROM " + getTipoClasse().getSimpleName() + " obj";
    }
}
