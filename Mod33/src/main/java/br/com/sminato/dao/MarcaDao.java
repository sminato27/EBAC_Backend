package br.com.sminato.dao;

import br.com.sminato.domain.Marca;
import br.com.sminato.jpa.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MarcaDao implements IMarcaDao {
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(marca);
        tx.commit();
        em.close();
        return marca;
    }
}
