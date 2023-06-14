package com.mongeat.controllers;

import com.mongeat.dtos.RestaurantDto;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.services.RestaurantService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/restaurants")
public class RestaurantController extends GenericController<RestaurantEntity, RestaurantDto> {

    @Inject
    RestaurantService restaurantService;

    public RestaurantController() {
        super(RestaurantDto.class);
    }

    @PostConstruct
    public void init() {
        setService(restaurantService);
    }
}
