package com.mongeat.models;

import com.mongeat.models.parts.Category;
import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurant extends GenericModel {
    private String name;
    private String image;
    private double rate;

    private List<Article> articles = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Location location;

    public Restaurant() { }

    public Restaurant(String id, String name, String image, double rate, Location location) {
        super(id);
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.location = location;
    }

    public Restaurant(String id, String name, String image, double rate, List<Article> articles, List<Category> categories, Location location) {
        this(id, name, image, rate, location);
        this.articles.addAll(articles);
        this.categories.addAll(categories);
    }
}
