package com.mongeat.controllers;

import com.mongeat.services.AdminService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/admin")
public class AdminController {

    @Inject
    AdminService adminService;

    /**
     * Creates a stub for the given entity.
     *
     * @param entity The entity type to create a stub for.
     * @return A Response object containing a success or error message.
     */
    @GET
    @Path("/stub/{entity}")
    public Response loadStub(@PathParam("entity") String entity) {
        if (adminService.createStub(entity)) {
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    /**
     * Drops the given entity.
     *
     * @param entity The entity type to drop.
     * @return A Response object containing a success or error message.
     */
    @DELETE
    @Path("/drop/{entity}")
    public Response dropAll(@PathParam("entity") String entity) {
        adminService.drop(entity);
        return Response.ok().build();
    }

    /**
     * Sets up the database with some data.
     *
     * @return A Response object containing a success or error message.
     */
    @GET
    @Path("setup")
    public Response setup() {
        if (adminService.setup()) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
}
