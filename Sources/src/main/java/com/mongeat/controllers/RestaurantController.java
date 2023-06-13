package com.mongeat.controllers;

import com.mongeat.entities.Restaurant;
import com.mongeat.services.RestaurantService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/restaurants")
public class RestaurantController extends GenericController<Restaurant> {

    @Inject
    RestaurantService restaurantService;

    @PostConstruct
    public void init() {
        setService(restaurantService);
    }
}
