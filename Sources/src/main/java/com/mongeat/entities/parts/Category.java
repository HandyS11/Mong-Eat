package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private String name;
    private String image;

    public Category() {}

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
