package com.mongeat.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurant extends GenericEntity {
    @NonNull
    private String name;
    @NonNull
    private String image;
    @NonNull
    private double rate;

    @NonNull
    private List<String> articles = new ArrayList<>();
    @NonNull
    private List<Category> categories = new ArrayList<>();
    @NonNull
    private Location location;

    public Restaurant(String id, String name, String image, double rate, Location location) {
        super(id);
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.location = location;
    }

    public Restaurant(String id, String name, String image, double rate, List<String> articles, List<Category> categories, Location location) {
        this(id, name, image, rate, location);
        this.articles.addAll(articles);
        this.categories.addAll(categories);
    }
}
