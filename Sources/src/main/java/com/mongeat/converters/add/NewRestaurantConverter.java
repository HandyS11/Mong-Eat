package com.mongeat.converters.add;

import com.mongeat.converters.IConverter;
import com.mongeat.converters.parts.CategoryConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.add.NewRestaurant;

import java.util.stream.Collectors;

/**
 * Converts a NewRestaurant to a RestaurantEntity
 */
public class NewRestaurantConverter implements IConverter<NewRestaurant, RestaurantEntity> {

    /**
     * Converts a NewRestaurant object to a RestaurantEntity object.
     *
     * @param object The NewRestaurant object to convert.
     * @return The RestaurantEntity object.
     */
    @Override
    public RestaurantEntity toEntity(NewRestaurant object) {
        if (object == null) {
            return null;
        }
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setName(object.getName());
        restaurantEntity.setImage(object.getImage());
        restaurantEntity.setRate(object.getRate());
        restaurantEntity.setArticles(object.getArticles());
        restaurantEntity.setCategories(object.getCategories().stream().map(CategoryConverter::toEntity).collect(Collectors.toList()));
        restaurantEntity.setLocation(LocationConverter.toEntity(object.getLocation()));
        return restaurantEntity;
    }

    /**
     * Converts a RestaurantEntity object to a NewRestaurant object.
     *
     * @param object The RestaurantEntity object to convert.
     * @return The NewRestaurant object.
     */
    @Override
    public NewRestaurant toModel(RestaurantEntity object) {
        if (object == null) {
            return null;
        }
        NewRestaurant restaurant = new NewRestaurant();
        restaurant.setName(object.getName());
        restaurant.setImage(object.getImage());
        restaurant.setRate(object.getRate());
        restaurant.setArticles(object.getArticles());
        restaurant.setCategories(object.getCategories().stream().map(CategoryConverter::toModel).collect(Collectors.toList()));
        restaurant.setLocation(LocationConverter.toModel(object.getLocation()));
        return restaurant;
    }
}
