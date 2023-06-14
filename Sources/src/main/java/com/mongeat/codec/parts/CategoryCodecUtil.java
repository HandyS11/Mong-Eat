package com.mongeat.codec.parts;

import com.mongeat.entities.parts.CategoryEntity;
import org.bson.Document;

public class CategoryCodecUtil {
    public static CategoryEntity extractCategory(Document categoryDoc) {
        CategoryEntity c = new CategoryEntity();

        c.setName(categoryDoc.getString("name"));
        c.setImage(categoryDoc.getString("image"));

        return c;
    }

    public static Document insertCategory(CategoryEntity c) {
        Document cat = new Document();

        cat.put("name", c.getName());
        cat.put("image", c.getImage());

        return cat;
    }
}
