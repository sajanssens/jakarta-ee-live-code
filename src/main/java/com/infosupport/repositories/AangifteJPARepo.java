package com.infosupport.repositories;

import com.infosupport.domain.Aangifte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
    public Aangifte add(Aangifte aangifte) {
        return null;
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
