package com.mongeat.stub;

import com.mongeat.entities.Restaurant;
import com.mongeat.entities.parts.Category;

import java.util.ArrayList;
import java.util.List;

public class RestaurantStub {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantStub() {
        Restaurant restaurant1 = new Restaurant("647998cb5c47e8017481fb87", "Chez patrick", "https://media-cdn.tripadvisor.com/media/photo-s/16/54/07/1c/chez-patrick-un-havre.jpg", 6.5 , List.of("64705dda1fe1d56fab1b17b2"), List.of(new Category("Kebab", "")), LocationStub.location1);
        Restaurant restaurant2 = new Restaurant("6479996ed405d82d32828e8d", "Le patoche", "https://media-cdn.tripadvisor.com/media/photo-s/11/75/ca/ca/un-havre-de-paix-au-coeur.jpg", 8.5, List.of("64705e06ae09d7bf1afc23ff", "64705e5df7e8ac3405332f57"), List.of(new Category("Pizzeria", ""), new Category("Japonais", "")), LocationStub.location1);
        Restaurant restaurant3 = new Restaurant("64799a051e8356531edb5725", "Le all in one", "https://www.theolivepress.es/wp-content/uploads/2022/03/All-in-1-Cafe-5.jpg", 9.5, List.of("64705e9520469bd3b59ec539", "64705dcabd367e78ccaddbe0", "64705dda1fe1d56fab1b17b2"), List.of(new Category("Tout", ""), new Category("Vraiment tout", "")), LocationStub.location1);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
