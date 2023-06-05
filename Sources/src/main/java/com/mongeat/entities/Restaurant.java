package com.mongeat.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurant {
    @NonNull
    private String name;
    @NonNull
    private String image;
    @NonNull
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Location location;

    public Restaurant(String name, String image, double rate) {
        this.name = name;
        this.image = image;
        this.rate = rate;
    }

    public Restaurant(String name, String image, double rate, List<String> articles, List<Category> categories, Location location) {
        this(name, image, rate);
        this.articles.addAll(articles);
        this.categories.addAll(categories);
        this.location = location;
    }
}
