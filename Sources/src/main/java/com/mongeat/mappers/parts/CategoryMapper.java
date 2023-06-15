package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.CategoryDto;
import com.mongeat.models.parts.Category;

public class CategoryMapper {

    public static Category toModel(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setImage(categoryDto.getImage());
        return category;
    }

    public static CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setImage(category.getImage());
        return categoryDto;
    }
}
