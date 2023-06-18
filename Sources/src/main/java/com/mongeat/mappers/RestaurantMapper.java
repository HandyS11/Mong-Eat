package com.mongeat.mappers;

import com.mongeat.dtos.RestaurantDto;
import com.mongeat.mappers.parts.CategoryMapper;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.Restaurant;

import java.util.stream.Collectors;

public class RestaurantMapper implements IMapper<Restaurant, RestaurantDto> {
    ArticleMapper articleMapper = new ArticleMapper();

    @Override
    public RestaurantDto toDto(Restaurant object) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(object.getId());
        restaurantDto.setName(object.getName());
        restaurantDto.setImage(object.getImage());
        restaurantDto.setRate(object.getRate());
        restaurantDto.setArticles(object.getArticles().stream().map(article -> articleMapper.toDto(article)).collect(Collectors.toList()));
        restaurantDto.setCategories(object.getCategories().stream().map(CategoryMapper::toDto).collect(Collectors.toList()));
        restaurantDto.setLocation(LocationMapper.toDto(object.getLocation()));
        return restaurantDto;
    }

    @Override
    public Restaurant toModel(RestaurantDto object) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(object.getId());
        restaurant.setName(object.getName());
        restaurant.setImage(object.getImage());
        restaurant.setRate(object.getRate());
        restaurant.setArticles(object.getArticles().stream().map(article -> articleMapper.toModel(article)).collect(Collectors.toList()));
        restaurant.setCategories(object.getCategories().stream().map(CategoryMapper::toModel).collect(Collectors.toList()));
        restaurant.setLocation(LocationMapper.toModel(object.getLocation()));
        return restaurant;
    }
}
