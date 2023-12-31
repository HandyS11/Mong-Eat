package com.mongeat.services;

import com.mongeat.converters.ArticleConverter;
import com.mongeat.converters.RestaurantConverter;
import com.mongeat.converters.add.NewRestaurantConverter;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.models.Article;
import com.mongeat.models.Restaurant;
import com.mongeat.models.add.NewRestaurant;
import com.mongeat.repositories.ArticleRepository;
import com.mongeat.repositories.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RestaurantService
 */
@Singleton
public class RestaurantService extends GenericService<Restaurant, NewRestaurant, RestaurantEntity> {
    @Inject
    RestaurantRepository restaurantRepository;
    @Inject
    ArticleRepository articleRepository;

    ArticleConverter articleConverter = new ArticleConverter();

    /**
     * Initializes the service.
     */
    @PostConstruct
    public void init() {
        setRepository(restaurantRepository);
        setConverter(new RestaurantConverter());
        setAddConverter(new NewRestaurantConverter());
    }

    @Override
    public Restaurant getById(String id) {
        RestaurantEntity entity = repository.findById(id);
        Restaurant restaurant = converter.toModel(entity);
        restaurant.setArticles(entity.getArticles().stream().map(a -> articleConverter.toModel(articleRepository.findById(a))).collect(Collectors.toList()));
        return restaurant;
    }

    @Override
    public Collection<Restaurant> getAll() {
        ArrayList<RestaurantEntity> entities = (ArrayList<RestaurantEntity>) repository.getAll();
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
        int i = 0;
        for (RestaurantEntity restaurant : entities) {
            restaurants.get(i).setArticles(getArticlesFromRestaurant(restaurant));
            i++;
        }
        return restaurants;
    }

    @Override
    public Collection<Restaurant> getPaginated(int page, int limit) {
        ArrayList<RestaurantEntity> entities = (ArrayList<RestaurantEntity>) repository.getPaginated(page, limit);
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
        int i = 0;
        for (RestaurantEntity restaurant : entities) {
            restaurants.get(i).setArticles(getArticlesFromRestaurant(restaurant));
            i++;
        }
        return restaurants;
    }

    private List<Article> getArticlesFromRestaurant(RestaurantEntity restaurant) {
        return restaurant.getArticles().stream().map(a -> articleConverter.toModel(articleRepository.findById(a))).collect(Collectors.toList());
    }

    public List<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name).stream().map(r -> converter.toModel(r)).collect(Collectors.toList());
    }
}
