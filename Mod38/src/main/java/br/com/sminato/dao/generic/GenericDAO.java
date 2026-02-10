package br.com.sminato.dao.generic;

import br.com.sminato.exceptions.DAOException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class GenericDAO<T extends Serializable, ID extends Serializable> implements IGenericDAO<T, ID> {

    private static EntityManagerFactory factory;
    
    protected Class<T> persistenteClass;

    static {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("Postgres");
        }
    }

    public GenericDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws DAOException {
        EntityManager em = openConnection();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DAOException("Erro ao cadastrar entidade", e);
        } finally {
            closeConnection(em);
        }
    }

    @Override
    public void excluir(T entity) throws DAOException {
        EntityManager em = openConnection();
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DAOException("Erro ao excluir entidade", e);
        } finally {
            closeConnection(em);
        }
    }

    @Override
    public T alterar(T entity) throws DAOException {
        EntityManager em = openConnection();
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DAOException("Erro ao alterar entidade", e);
        } finally {
            closeConnection(em);
        }
    }

    @Override
    public T consultar(ID id) throws DAOException {
        EntityManager em = openConnection();
        try {
            return em.find(persistenteClass, id);
        } catch (Exception e) {
            throw new DAOException("Erro ao consultar entidade", e);
        } finally {
            closeConnection(em);
        }
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        EntityManager em = openConnection();
        try {
            List<T> list = em.createQuery("SELECT c FROM " + persistenteClass.getSimpleName() + " c", persistenteClass).getResultList();
            return list;
        } catch (Exception e) {
            throw new DAOException("Erro ao buscar todas as entidades", e);
        } finally {
            closeConnection(em);
        }
    }

    protected EntityManager openConnection() {
        return factory.createEntityManager();
    }

    protected void closeConnection(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
