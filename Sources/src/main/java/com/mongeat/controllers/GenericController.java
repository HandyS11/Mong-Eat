package com.mongeat.controllers;

import com.mongeat.entities.GenericEntity;
import com.mongeat.services.GenericService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;

import java.util.Collection;

public abstract class GenericController<T extends GenericEntity, G> {
   private final Class<G> entityClass;
    protected GenericService<T> service;

    protected GenericController(Class<G> entityClass) {
        this.entityClass = entityClass;
    }

    public void setService(@NonNull GenericService<T> service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
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
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        var entities = service.getAll();
        return Response.ok(entities).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginated(@PathParam("page") int page, @PathParam("limit") int limit) {
        return Response.ok(service.getPaginated(page, limit)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(T entity) {
        try {
            var e = service.insert(entity);
            return Response.status(Response.Status.CREATED)
                           .entity(e)
                           .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @POST
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertAll(Collection<T> entities) {
        try {
            var e = service.insertAll(entities);
            return Response.status(Response.Status.CREATED)
                           .entity(e)
                           .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(T entity) {
        try {
            service.update(entity);
            return Response.ok(entity).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @PUT
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAll(Collection<T> entities) {
        try {
            service.updateAll(entities);
            return Response.ok(entities).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            service.delete(service.getById(id));
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @DELETE
    @Path("/all")
    public Response deleteAll() {
        try {
            service.deleteAll(service.getAll());
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @DELETE
    @Path("/drop")
    public Response drop() {
        try {
            service.drop();
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @GET
    @Path("/exists/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response exists(@PathParam("id") String id) {
        try {
            service.exists(id);
            return Response.ok(true).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCount() {
        try {
            return Response.ok(service.getCount()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }
}
