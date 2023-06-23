package com.mongeat.converters;

import com.mongeat.converters.parts.CategoryConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.GenericModel;
import com.mongeat.models.Restaurant;

import java.util.stream.Collectors;

/**
 * Converts a Restaurant to a RestaurantEntity
 */
public class RestaurantConverter implements IConverter<Restaurant, RestaurantEntity> {

    /**
     * Converts a Restaurant object to a RestaurantEntity object.
     *
     * @param object The Restaurant object to convert.
     * @return The RestaurantEntity object.
     */
    @Override
    public RestaurantEntity toEntity(Restaurant object) {
        if (object == null) {
            return null;
        }
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

    /**
     * Converts a RestaurantEntity object to a Restaurant object.
     *
     * @param object The RestaurantEntity object to convert.
     * @return The Restaurant object.
     */
    @Override
    public Restaurant toModel(RestaurantEntity object) {
        if (object == null) {
            return null;
        }
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
