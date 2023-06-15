package com.mongeat.services;

import com.mongeat.converters.ArticleConverter;
import com.mongeat.converters.RestaurantConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.Restaurant;
import com.mongeat.repositories.ArticleRepository;
import com.mongeat.repositories.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Collection;
import java.util.stream.Collectors;

@Singleton
public class RestaurantService extends GenericService<Restaurant, RestaurantEntity> {

    @Inject
    RestaurantRepository restaurantRepository;
    @Inject
    ArticleRepository articleRepository;

    ArticleConverter articleConverter = new ArticleConverter();

    @PostConstruct
    public void init() {
        setRepository(restaurantRepository);
        setConverter(new RestaurantConverter());
    }

    /*@Override
    public Restaurant getById(String id) {
        RestaurantEntity entity = repository.findById(id);
        Restaurant restaurant = converter.toModel(entity);
        restaurant.setArticles(entity.getArticles().stream().map(a -> articleConverter.toModel(articleRepository.findById(a))).collect(Collectors.toList()));
        return restaurant;
    }

    @Override
    public Collection<Restaurant> getAll() {
        Collection<RestaurantEntity> entities = repository.getAll();
        Collection<Restaurant> restaurants = entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
        return restaurants;
    }*/
}
