package com.mongeat.models.add;

import com.mongeat.models.parts.Category;
import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewRestaurant {
    private String name;
    private String image;
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Location location;

    public NewRestaurant() { }

    public NewRestaurant(String name, String image, double rate, Location location) {
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.location = location;
    }

    public NewRestaurant(String name, String image, double rate, List<String> articles, List<Category> categories, Location location) {
        this(name, image, rate, location);
        this.articles.addAll(articles);
        this.categories.addAll(categories);
    }
}
