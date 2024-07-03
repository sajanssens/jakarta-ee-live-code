package com.infosupport.resources;

import com.infosupport.domain.Aangifte;
import com.infosupport.repositories.AangifteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("aangiftes") // impliciet requestscoped
public class AangiftesResource {

    @Inject
    private AangifteRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aangifte> getAll() {
        return repo.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Aangifte add(Aangifte aangifte) {
        return repo.add(aangifte);
    }
}
