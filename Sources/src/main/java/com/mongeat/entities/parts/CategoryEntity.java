package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryEntity {
    private String name;
    private String image;

    public CategoryEntity() {}

    public CategoryEntity(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
