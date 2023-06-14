package com.mongeat.mappers;

import com.mongeat.dtos.RestaurantDto;
import com.mongeat.mappers.parts.CategoryMapper;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.Restaurant;

import java.util.stream.Collectors;

public class RestaurantMapper {

    public static Restaurant mapToRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setRate(restaurantDto.getRate());
        restaurant.setArticles(restaurantDto.getArticles().stream().map(ArticleMapper::mapToArticle).collect(Collectors.toList()));
        restaurant.setCategories(restaurantDto.getCategories().stream().map(CategoryMapper::mapToCategory).collect(Collectors.toList()));
        restaurant.setLocation(LocationMapper.mapToLocation(restaurantDto.getLocation()));
        return restaurant;
    }

    public static RestaurantDto mapToRestaurantDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setRate(restaurant.getRate());
        restaurantDto.setArticles(restaurant.getArticles().stream().map(ArticleMapper::mapToArticleDto).collect(Collectors.toList()));
        restaurantDto.setCategories(restaurant.getCategories().stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList()));
        restaurantDto.setLocation(LocationMapper.mapToLocationDto(restaurant.getLocation()));
        return restaurantDto;
    }
}
