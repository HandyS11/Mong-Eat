package com.mongeat.entities;

import com.mongeat.entities.parts.CategoryEntity;
import com.mongeat.entities.parts.LocationEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * RestaurantEntity
 */
@Getter
@Setter
public class RestaurantEntity extends GenericEntity {
    public static final String COLLECTION_NAME = "restaurants";

    private String name;
    private String image;
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<CategoryEntity> categories = new ArrayList<>();
    private LocationEntity location;

    public RestaurantEntity() {
        super(new ObjectId().toHexString());
    }

    /**
     * @param id Id of the restaurant
     * @param name Name of the restaurant
     * @param image Url of the image
     * @param rate Rate of the restaurant
     * @param location LocationEntity
     */
    public RestaurantEntity(String id, String name, String image, double rate, LocationEntity location) {
        super(id);
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.location = location;
    }

    /**
     * @param id Id of the restaurant
     * @param name Name of the restaurant
     * @param image Url of the image
     * @param rate Rate of the restaurant
     * @param articles List of articles
     * @param categories List of categories
     * @param location LocationEntity
     */
    public RestaurantEntity(String id, String name, String image, double rate, List<String> articles, List<CategoryEntity> categories, LocationEntity location) {
        this(id, name, image, rate, location);
        this.articles.addAll(articles);
        this.categories.addAll(categories);
    }
}
