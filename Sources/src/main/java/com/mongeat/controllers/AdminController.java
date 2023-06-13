package com.mongeat.controllers;

import com.mongeat.services.AdminService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")
public class AdminController {

    @Inject
    AdminService adminService;

    @GET
    @Path("/stub/{entity}")
    public Response loadStub(@PathParam("entity") String entity) {
        if (adminService.createStub(entity)) {
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @DELETE
    @Path("/drop/{entity}")
    public Response dropAll(@PathParam("entity") String entity) {
        adminService.drop(entity);
        return Response.ok().build();
    }

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
