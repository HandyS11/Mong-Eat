package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private String name;
    private String image;

    public CategoryDto() { }

    public CategoryDto(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
