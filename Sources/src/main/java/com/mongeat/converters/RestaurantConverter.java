package com.mongeat.converters;

import com.mongeat.converters.parts.CategoryConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.GenericModel;
import com.mongeat.models.Restaurant;

import java.util.stream.Collectors;

public class RestaurantConverter implements IConverter<Restaurant, RestaurantEntity> {
    @Override
    public RestaurantEntity toEntity(Restaurant object) {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setId(object.getId());
        restaurantEntity.setName(object.getName());
        restaurantEntity.setImage(object.getImage());
        restaurantEntity.setRate(object.getRate());
        restaurantEntity.setArticles(object.getArticles().stream().map(GenericModel::getId).collect(Collectors.toList()));
        restaurantEntity.setCategories(object.getCategories().stream().map(CategoryConverter::toEntity).collect(Collectors.toList()));
        restaurantEntity.setLocation(LocationConverter.toEntity(object.getLocation()));
        return restaurantEntity;
    }

    @Override
    public Restaurant toModel(RestaurantEntity object) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(object.getId());
        restaurant.setName(object.getName());
        restaurant.setImage(object.getImage());
        restaurant.setRate(object.getRate());
        // impossible :/                                yet :)
        restaurant.setCategories(object.getCategories().stream().map(CategoryConverter::toModel).collect(Collectors.toList()));
        restaurant.setLocation(LocationConverter.toModel(object.getLocation()));
        return restaurant;
    }
}
