package com.mongeat.models.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * Category
 */
@Getter
@Setter
@RegisterForReflection
public class Category {
    private String name;
    private String image;

    public Category() {}

    /**
     * @param name Name of the category
     * @param image url of the category
     */
    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
