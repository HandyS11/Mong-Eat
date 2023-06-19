package com.mongeat.controllers;

import com.mongeat.dtos.RestaurantDto;
import com.mongeat.dtos.add.NewRestaurantDto;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.mappers.RestaurantMapper;
import com.mongeat.mappers.add.NewRestaurantMapper;
import com.mongeat.models.Restaurant;
import com.mongeat.models.add.NewRestaurant;
import com.mongeat.services.RestaurantService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/restaurants")
public class RestaurantController extends GenericController<RestaurantDto, NewRestaurantDto, Restaurant, NewRestaurant, RestaurantEntity> {

    @Inject
    RestaurantService restaurantService;

    @PostConstruct
    public void init() {
        setService(restaurantService);
        setMapper(new RestaurantMapper());
        setPostMapper(new NewRestaurantMapper());
    }

    @Path("/byName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name) {
        Restaurant restaurant = restaurantService.findByName(name);
        if (restaurant != null) {
            return Response.ok(mapper.toDto(restaurant)).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Restaurant with name " + name + " not found")
                    .build();
        }
    }
}
