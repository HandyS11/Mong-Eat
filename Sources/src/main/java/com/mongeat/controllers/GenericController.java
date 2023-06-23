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

/**
 * An abstract controller class providing CRUD operations for entities.
 * The specific type of entity is defined by the generic parameter E, which extends GenericEntity.
 * The specific type of model is defined by the generic parameter M.
 * The specific type of model for insertion is defined by the generic parameter MA.
 * The specific type of DTO is defined by the generic parameter D.
 * The specific type of DTO for insertion is defined by the generic parameter DA.
 */
public abstract class GenericController<D, DA, M, MA, E extends GenericEntity> {
    protected GenericService<M, MA, E> service;
    protected IMapper<M, D> mapper;
    protected IMapper<MA, DA> postMapper;

    /**
     * Sets the service to be used by this controller.
     *
     * @param service The service to be used by this controller.
     */
    protected void setService(@NonNull GenericService<M, MA, E> service) {
        this.service = service;
    }

    /**
     * Sets the mapper to be used by this controller.
     *
     * @param mapper The mapper to be used by this controller.
     */
    protected void setMapper(@NonNull IMapper<M, D> mapper) {
        this.mapper = mapper;
    }

    /**
     * Sets the post mapper to be used by this controller.
     *
     * @param postMapper The post mapper to be used by this controller.
     */
    protected void setPostMapper(@NonNull IMapper<MA, DA> postMapper) {
        this.postMapper = postMapper;
    }

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return A Response object containing the entity, or an error message if the entity does not exist.
     */
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

    /**
     * Retrieves all entities.
     *
     * @return A Response object containing a list of all entities.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Collection<M> models = service.getAll();
        return Response.ok(models.stream().map(m -> mapper.toDto(m)).collect(Collectors.toList())).build();
    }

    /**
     * Retrieves a paginated list of entities.
     *
     * @param page The page number.
     * @param limit The number of entities per page.
     * @return A Response object containing a paginated list of entities.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginated(@QueryParam("page") int page, @QueryParam("limit") int limit) {
        return Response.ok(service.getPaginated(page, limit)).build();
    }

    /**
     * Inserts an entity.
     *
     * @param dto The DTO containing the entity to insert.
     * @return A Response object containing the inserted entity, or an error message if the entity could not be inserted.
     */
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

    /**
     * Updates an entity.
     *
     * @param dto The DTO containing the entity to update.
     * @return A Response object containing the updated entity, or an error message if the entity could not be updated.
     */
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

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     * @return A Response object containing the deleted entity, or an error message if the entity could not be deleted.
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            service.delete(id);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    /**
     * Deletes all entities.
     *
     * @return A Response object containing the deleted entities, or an error message if the entities could not be deleted.
     */
    @DELETE
    @Path("/all")
    public Response deleteAll() {
        try {
            service.deleteAll();
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    /**
     * Deletes all entities.
     *
     * @return A Response object containing the deleted entities, or an error message if the entities could not be deleted.
     */
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

    /**
     * Checks if an entity exists by its ID.
     *
     * @param id The ID of the entity to check.
     * @return A Response object containing a boolean indicating whether the entity exists, or an error message if the ID is invalid.
     */
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

    /**
     * Retrieves the number of entities.
     *
     * @return A Response object containing the number of entities.
     */
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
