package com.mongeat.models.add;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * NewArticle
 */
@Getter
@Setter
@RegisterForReflection
public class NewArticle {
    private String name;
    private String image;
    private double price;

    public NewArticle() {}

    /**
     * @param name Name of the article
     * @param image url of the article
     * @param price Price of the article
     */
    public NewArticle(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
