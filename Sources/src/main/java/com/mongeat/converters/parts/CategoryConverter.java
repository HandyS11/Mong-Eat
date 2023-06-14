package com.mongeat.converters.parts;

import com.mongeat.entities.parts.CategoryEntity;
import com.mongeat.models.parts.Category;

public class CategoryConverter {

    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setName(categoryEntity.getName());
        category.setImage(categoryEntity.getImage());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setImage(category.getImage());
        return categoryEntity;
    }
}
