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
}
