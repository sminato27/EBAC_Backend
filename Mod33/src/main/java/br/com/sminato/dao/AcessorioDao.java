package br.com.sminato.dao;

import br.com.sminato.domain.Acessorio;
import br.com.sminato.jpa.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AcessorioDao implements IAcessorioDao {
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(acessorio);
        tx.commit();
        em.close();
        return acessorio;
    }
}
