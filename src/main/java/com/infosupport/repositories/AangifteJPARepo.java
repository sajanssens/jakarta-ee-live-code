package com.infosupport.repositories;

import com.infosupport.domain.Aangifte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped @Ag
public class AangifteJPARepo implements Repo<Aangifte> {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;

    @Override
    public List<Aangifte> findAll() {
        return em.createQuery("select a from Aangifte a", Aangifte.class).getResultList();
    }

    @Override
    @Transactional
    public Aangifte add(Aangifte aangifte) {
        // em.getTransaction().begin();
        em.persist(aangifte);
        // em.getTransaction().commit();
        return aangifte;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Aangifte update(Aangifte aangifte) {
        return null;
    }

    @Override
    public Aangifte get(int id) {
        return null;
    }
}
