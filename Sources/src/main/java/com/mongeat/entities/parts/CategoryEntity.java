package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * CategoryEntity
 */
@Getter
@Setter
public class CategoryEntity {
    private String name;
    private String image;

    public CategoryEntity() {}

    /**
     * @param name Name of the category
     * @param image Url of the image
     */
    public CategoryEntity(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
