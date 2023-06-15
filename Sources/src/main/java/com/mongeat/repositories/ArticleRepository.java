package com.mongeat.repositories;

import com.mongeat.entities.ArticleEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class ArticleRepository extends GenericRepository<ArticleEntity> {

    @Override
    public MongoCollection<ArticleEntity> getCollection() {
        return database.getCollection(ArticleEntity.COLLECTION_NAME, ArticleEntity.class);
    }
}
