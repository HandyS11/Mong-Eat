package com.mongeat.services;

import com.mongeat.converters.RestaurantConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.Restaurant;
import com.mongeat.repositories.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class RestaurantService extends GenericService<Restaurant, RestaurantEntity> {

    @Inject
    RestaurantRepository restaurantRepository;

    @PostConstruct
    public void init() {
        setRepository(restaurantRepository);
        setConverter(new RestaurantConverter());
    }
}
