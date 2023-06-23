package com.mongeat.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

/**
 * ArticleEntity
 */
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

    /**
     * @param id Id of the article
     * @param name Name of the article
     * @param image Url of the image
     * @param price Price of the article
     */
    public ArticleEntity(String id, String name, String image, double price) {
        super(id);
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
