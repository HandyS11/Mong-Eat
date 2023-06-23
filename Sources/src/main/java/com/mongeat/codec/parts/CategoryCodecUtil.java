package com.mongeat.codec.parts;

import com.mongeat.entities.parts.CategoryEntity;
import org.bson.Document;

/**
 * Utility class for CategoryEntity
 */
public class CategoryCodecUtil {

    /**
     * Extracts a CategoryEntity from a Document
     * @param categoryDoc the Document to extract from
     * @return the CategoryEntity
     */
    public static CategoryEntity extractCategory(Document categoryDoc) {
        CategoryEntity c = new CategoryEntity();

        c.setName(categoryDoc.getString("name"));
        c.setImage(categoryDoc.getString("image"));

        return c;
    }

    /**
     * Inserts a CategoryEntity into a Document
     * @param c the CategoryEntity to insert
     * @return the Document
     */
    public static Document insertCategory(CategoryEntity c) {
        Document cat = new Document();

        cat.put("name", c.getName());
        cat.put("image", c.getImage());

        return cat;
    }
}
