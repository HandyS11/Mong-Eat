package com.mongeat.mappers.add;

import com.mongeat.dtos.add.NewRestaurantDto;
import com.mongeat.mappers.IMapper;
import com.mongeat.mappers.parts.CategoryMapper;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.add.NewRestaurant;

import java.util.stream.Collectors;

public class NewRestaurantMapper implements IMapper<NewRestaurant, NewRestaurantDto> {

    @Override
    public NewRestaurantDto toDto(NewRestaurant object) {
        NewRestaurantDto restaurantDto = new NewRestaurantDto();
        restaurantDto.setName(object.getName());
        restaurantDto.setImage(object.getImage());
        restaurantDto.setRate(object.getRate());
        restaurantDto.setArticles(object.getArticles());
        restaurantDto.setCategories(object.getCategories().stream().map(CategoryMapper::toDto).collect(Collectors.toList()));
        restaurantDto.setLocation(LocationMapper.toDto(object.getLocation()));
        return restaurantDto;
    }

    @Override
    public NewRestaurant toModel(NewRestaurantDto object) {
        NewRestaurant restaurant = new NewRestaurant();
        restaurant.setName(object.getName());
        restaurant.setImage(object.getImage());
        restaurant.setRate(object.getRate());
        restaurant.setArticles(object.getArticles());
        restaurant.setCategories(object.getCategories().stream().map(CategoryMapper::toModel).collect(Collectors.toList()));
        restaurant.setLocation(LocationMapper.toModel(object.getLocation()));
        return restaurant;
    }
}
