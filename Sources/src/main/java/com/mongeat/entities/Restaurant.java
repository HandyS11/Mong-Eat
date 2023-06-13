package com.mongeat.entities;

import com.mongeat.entities.parts.Category;
import com.mongeat.entities.parts.Location;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurant extends GenericEntity {
    public static final String COLLECTION_NAME = "restaurants";

    private String name;
    private String image;
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Location location;

    public Restaurant() {
        super(new ObjectId().toHexString());
    }

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
