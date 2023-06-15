package com.mongeat.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article extends GenericModel {
    private String name;
    private String image;
    private double price;

    public Article() {}

    public Article(String id, String name, String image, double price) {
        super(id);
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
