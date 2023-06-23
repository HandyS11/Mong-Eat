package com.mongeat.repositories;

import com.mongeat.entities.ArticleEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * ArticleRepository
 */
@Singleton
public class ArticleRepository extends GenericRepository<ArticleEntity> {

    /**
     * @return The collection of the model
     */
    @Override
    public MongoCollection<ArticleEntity> getCollection() {
        return database.getCollection(ArticleEntity.COLLECTION_NAME, ArticleEntity.class);
    }

    /**
     * Look for articles by name
     *
     * @param name Name of the article
     * @return List of articles
     */
    public List<ArticleEntity> findByName(String name) {
        Bson filter = Filters.regex("name", name.trim(), "i");
        return getCollection().find(filter).into(new ArrayList<>());
    }
}
