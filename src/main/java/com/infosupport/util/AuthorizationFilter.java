package com.infosupport.util;

import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;
import static jakarta.ws.rs.core.Response.status;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext req) throws IOException {
        if (resourceInfo.getResourceMethod().isAnnotationPresent(NotSecured.class)) {
            return; // stop filtering and proceed.
        }

        String authorization = req.getHeaderString("Authorization");
        if (authorization == null || !authorization.equals("true")) {
            req.abortWith(status(UNAUTHORIZED).build());
        }
    }
}
