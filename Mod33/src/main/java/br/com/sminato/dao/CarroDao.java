package br.com.sminato.dao;

import br.com.sminato.domain.Carro;
import br.com.sminato.jpa.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarroDao implements ICarroDao {
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(carro);
        tx.commit();
        em.close();
        return carro;
    }

    @Override
    public List<Carro> buscarPorMarca(String nomeMarca) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Carro c JOIN c.marca m WHERE m.nome = :nome";
        TypedQuery<Carro> query = em.createQuery(jpql, Carro.class);
        query.setParameter("nome", nomeMarca);
        List<Carro> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Carro> buscarPorAcessorio(String descricaoAcessorio) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Carro c JOIN c.acessorios a WHERE a.descricao = :descricao";
        TypedQuery<Carro> query = em.createQuery(jpql, Carro.class);
        query.setParameter("descricao", descricaoAcessorio);
        List<Carro> list = query.getResultList();
        em.close();
        return list;
    }
}
