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

public abstract class GenericController<D, DA, M, MA, E extends GenericEntity> {
    protected GenericService<M, MA, E> service;
    protected IMapper<M, D> mapper;
    protected IMapper<MA, DA> postMapper;

    protected void setService(@NonNull GenericService<M, MA, E> service) {
        this.service = service;
    }

    protected void setMapper(@NonNull IMapper<M, D> mapper) {
        this.mapper = mapper;
    }

    protected void setPostMapper(@NonNull IMapper<MA, DA> postMapper) {
        this.postMapper = postMapper;
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
    public Response getPaginated(@QueryParam("page") int page, @QueryParam("limit") int limit) {
        return Response.ok(service.getPaginated(page, limit)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(DA dto) {
        try {
            service.insert(postMapper.toModel(dto));
            return Response.status(Response.Status.CREATED)
                           .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    //TODO: not working (it might be a parsing problem)
    /*@POST
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAll(Collection<DA> dtos) {
        try {
            List<MA> models = dtos.stream().map(d -> postMapper.toModel(d)).collect(Collectors.toList());
            service.insertAll(models);
            return Response.status(Response.Status.CREATED)
                            .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }*/

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
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

    //TODO: not working (it might be a parsing problem)
    /*@PUT
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAll(Collection<D> dtos) {
        try {
            List<M> models = dtos.stream().map(d -> mapper.toModel(d)).collect(Collectors.toList());
            service.updateAll(models);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }*/

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
