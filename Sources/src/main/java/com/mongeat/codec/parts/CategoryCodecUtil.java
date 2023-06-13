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

    public static Document insertCategory(Category c) {
        Document cat = new Document();

        cat.put("name", c.getName());
        cat.put("image", c.getImage());

        return cat;
    }
}
