package com.mongeat.controllers;

import com.mongeat.entities.GenericEntity;
import com.mongeat.mappers.IMapper;
import com.mongeat.services.GenericService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class GenericController<D, M, E extends GenericEntity> {
    protected GenericService<M, E> service;
    protected IMapper<M, D> mapper;

    public void setService(@NonNull GenericService<M, E> service) {
        this.service = service;
    }
    public void setMapper(@NonNull IMapper<M, D> mapper) {
        this.mapper = mapper;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        try {
            M model = service.getById(id);
            if (model != null) {
                return Response.ok(mapper.toDto(model)).build();
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
        Collection<M> models = service.getAll();
        return Response.ok(models.stream().map(m -> mapper.toDto(m)).collect(Collectors.toList())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginated(@PathParam("page") int page, @PathParam("limit") int limit) {
        return Response.ok(service.getPaginated(page, limit)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(D dto) {
        try {
            service.insert(mapper.toModel(dto));
            return Response.status(Response.Status.CREATED)
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
    public Response insertAll(Collection<D> dtos) {
        try {
            service.insertAll(dtos.stream().map(d -> mapper.toModel(d)).collect(Collectors.toList()));
            return Response.status(Response.Status.CREATED)
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
    public Response update(D dto) {
        try {
            service.update(mapper.toModel(dto));
            return Response.ok().build();
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
    public Response updateAll(Collection<D> dtos) {
        try {
            service.updateAll(dtos.stream().map(d -> mapper.toModel(d)).collect(Collectors.toList()));
            return Response.ok().build();
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
            return Response.ok(service.exists(id)).build();
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
