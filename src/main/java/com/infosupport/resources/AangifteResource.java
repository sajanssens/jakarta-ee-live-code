package com.infosupport.resources;

import com.infosupport.domain.Aangifte;
import com.infosupport.repositories.AangifteRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Dependent
@Produces(MediaType.APPLICATION_JSON)
public class AangifteResource {

    private int id;

    @Inject
    private AangifteRepository repo;

    @DELETE
    public void remove() {
        repo.remove(id);
    }

    @GET
    public Aangifte getOne(@Context UriInfo uri) {
        Aangifte aangifte = repo.get(id);
        URI absolutePath = uri.getAbsolutePath();
        aangifte.set_self(absolutePath.toString());
        return aangifte;
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
