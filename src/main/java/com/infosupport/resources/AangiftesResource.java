package com.infosupport.resources;

import com.infosupport.domain.Aangifte;
import com.infosupport.domain.Aangiftes;
import com.infosupport.repositories.Ag;
import com.infosupport.repositories.Repo;
import com.infosupport.util.NotSecured;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Path("aangiftes") // impliciet requestscoped
public class AangiftesResource {

    @Inject @Ag
    private Repo<Aangifte> repo;

    @Inject
    private AangifteResource aangifteResource;

    @NotSecured
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(description = "Returns all aangiftes when no query string is included.")
    public Aangiftes getAll(
            @Parameter(description = "to search on aangifte text (containing)")
            @QueryParam("q") String q) {
        return new Aangiftes(repo.findAll());
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Aangifte add(Aangifte aangifte) {
        return repo.add(aangifte);
    }

    @Path("{id}")
    public AangifteResource aangifte(@PathParam("id") int id) {
        System.out.println("AangifteResource");
        return this.aangifteResource.with(id);
    }
}
