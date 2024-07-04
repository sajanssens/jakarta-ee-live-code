package com.infosupport.repositories;

import com.infosupport.domain.Aangifte;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped // == singleton
public class AangifteRepository {
    private final List<Aangifte> list = new ArrayList<>(
            List.of(
                    new Aangifte(1, "16.33.86.146", 200.00),
                    Aangifte.builder().id(2).bsn("123").bedrag(100.56).build(),
                    new Aangifte(3, "16.33.86.147", 400.00),
                    new Aangifte(4, "16.33.86.148", 600.00)
            )
    );

    public List<Aangifte> findAll() {
        return list;
    }

    public Aangifte add(Aangifte aangifte) {
        this.list.add(aangifte);
        return aangifte;
    }

    public void remove(int id) {

    }

    public Aangifte get(int id) {
        return this.list.get(id);
    }
}
