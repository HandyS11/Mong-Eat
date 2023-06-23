package com.mongeat.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * Article
 */
@Getter
@Setter
@RegisterForReflection
public class Article extends GenericModel {
    private String name;
    private String image;
    private double price;

    public Article() {}

    /**
     * @param id Id of the article
     * @param name Name of the article
     * @param image url of the article
     * @param price Price of the article
     */
    public Article(String id, String name, String image, double price) {
        super(id);
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
