package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.CategoryDto;
import com.mongeat.models.parts.Category;

/**
 * Map Category to CategoryDto and vice versa
 */
public class CategoryMapper {

    /**
     * Map CategoryDto to Category
     * @param categoryDto CategoryDto
     * @return Category
     */
    public static Category toModel(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setImage(categoryDto.getImage());
        return category;
    }

    /**
     * Map Category to CategoryDto
     * @param category Category
     * @return CategoryDto
     */
    public static CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setImage(category.getImage());
        return categoryDto;
    }
}
