package com.mongeat.controllers;

import com.mongeat.entities.GenericEntity;
import com.mongeat.services.GenericService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;
import lombok.Setter;

@Setter
public class GenericController<T extends GenericEntity> {
    @NonNull
    protected GenericService<T> service;

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        try {
            T entity = service.getById(id);
            if (entity != null) {
                return Response.ok(entity).build();
            }
            else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Entity with id " + id + " not found")
                        .build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid id format: " + id)
                    .build();
        }
    }

    @GET
    public Response getAll() {
        return Response.ok(service.getAll()).build();
    }
}
