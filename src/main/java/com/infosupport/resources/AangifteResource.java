package com.infosupport.resources;

import com.infosupport.domain.Aangifte;
import com.infosupport.repositories.AangifteRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Dependent
public class AangifteResource {

    private int id;

    @Inject
    private AangifteRepository repo;

    @DELETE
    public void remove() {
        repo.remove(id);
    }

    @GET
    public Aangifte getOne() {
        return repo.get(id);
    }

    @GET
    @Path("bijlages")
    public void getAangifteBijlages() {
        // repo.get(id);
    }

    public AangifteResource with(int id) {
        this.id = id;
        return this;
    }
}
