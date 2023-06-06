package com.mongeat.services;

import com.mongeat.entities.Restaurant;
import com.mongeat.repositories.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class RestaurantService extends GenericService<Restaurant> {

    @Inject
    RestaurantRepository restaurantRepository;

    @PostConstruct
    public void init() {
        setRepository(restaurantRepository);
    }
}
