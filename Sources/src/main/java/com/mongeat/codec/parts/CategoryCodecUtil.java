package com.mongeat.codec.parts;

import com.mongeat.entities.parts.Category;
import org.bson.Document;

public class CategoryCodecUtil {
    public static Category extractCategory(Document categoryDoc) {
        Category c = new Category();

        c.setName(categoryDoc.getString("name"));
        c.setImage(categoryDoc.getString("image"));

        return c;
    }
}
