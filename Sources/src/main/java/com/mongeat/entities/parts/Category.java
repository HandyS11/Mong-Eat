package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Category {
    @NonNull
    private String name;
    @NonNull
    private String image;

    public Category() {}

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
