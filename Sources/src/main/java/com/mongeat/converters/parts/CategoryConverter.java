package com.mongeat.converters.parts;

import com.mongeat.entities.parts.CategoryEntity;
import com.mongeat.models.parts.Category;

/**
 * Converts a Category to a CategoryEntity
 */
public class CategoryConverter {

    /**
     * Converts a CategoryEntity object to a Category object.
     *
     * @param categoryEntity The CategoryEntity object to convert.
     * @return The Category object.
     */
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setName(categoryEntity.getName());
        category.setImage(categoryEntity.getImage());
        return category;
    }

    /**
     * Converts a Category object to a CategoryEntity object.
     *
     * @param category The Category object to convert.
     * @return The CategoryEntity object.
     */
    public static CategoryEntity toEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setImage(category.getImage());
        return categoryEntity;
    }
}
