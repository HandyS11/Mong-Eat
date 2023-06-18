package com.mongeat.stub;

import com.mongeat.entities.RestaurantEntity;
import com.mongeat.entities.parts.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantStub {
    private final List<RestaurantEntity> restaurants = new ArrayList<>();

    public RestaurantStub() {
        RestaurantEntity restaurant1 = new RestaurantEntity("648b3d0a263a7897b3099e70", "Chez patrick", "https://media-cdn.tripadvisor.com/media/photo-s/16/54/07/1c/chez-patrick-un-havre.jpg", 6.5 , List.of("64705dda1fe1d56fab1b17b2"), List.of(new CategoryEntity("Kebab", "")), LocationStub.location1);
        RestaurantEntity restaurant2 = new RestaurantEntity("648b3d0a263a7897b3099e71", "Le patoche", "https://media-cdn.tripadvisor.com/media/photo-s/11/75/ca/ca/un-havre-de-paix-au-coeur.jpg", 8.5, List.of("64705e06ae09d7bf1afc23ff", "64705e5df7e8ac3405332f57"), List.of(new CategoryEntity("Pizzeria", ""), new CategoryEntity("Japonais", "")), LocationStub.location1);
        RestaurantEntity restaurant3 = new RestaurantEntity("648b3d0a263a7897b3099e72", "Le all in one", "https://www.theolivepress.es/wp-content/uploads/2022/03/All-in-1-Cafe-5.jpg", 9.5, List.of("64705e9520469bd3b59ec539", "64705dcabd367e78ccaddbe0", "64705dda1fe1d56fab1b17b2"), List.of(new CategoryEntity("Tout", ""), new CategoryEntity("Vraiment tout", "")), LocationStub.location1);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
    }

    public List<RestaurantEntity> getRestaurants() {
        return restaurants;
    }
}
