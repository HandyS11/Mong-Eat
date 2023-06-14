package com.mongeat.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class ArticleEntity extends GenericEntity {
    public static final String COLLECTION_NAME = "articles";

    private String name;
    private String image;
    private double price;

    public ArticleEntity() {
        super(new ObjectId().toHexString());
    }

    public ArticleEntity(String id, String name, String image, double price) {
        super(id);
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
