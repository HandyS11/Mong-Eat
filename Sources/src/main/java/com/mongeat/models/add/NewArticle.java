package com.mongeat.models.add;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewArticle {
    private String name;
    private String image;
    private double price;

    public NewArticle() {}

    public NewArticle(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
