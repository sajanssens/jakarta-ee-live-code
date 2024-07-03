package com.infosupport.resources;

import com.infosupport.domain.Aangifte;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("aangiftes")
public class AangiftesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aangifte> getAll() {
        return List.of(
                new Aangifte("16.33.86.146", 200.00),
                new Aangifte("16.33.86.147", 400.00));

        // return Response.ok(new Aangifte("16.33.86.146", 200.00)).build();
    }
}
