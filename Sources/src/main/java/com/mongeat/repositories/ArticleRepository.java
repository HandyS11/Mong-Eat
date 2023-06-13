package com.mongeat.repositories;

import com.mongeat.entities.Article;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class ArticleRepository extends GenericRepository<Article> {

    @Override
    public MongoCollection<Article> getCollection() {
        return database.getCollection(Article.COLLECTION_NAME, Article.class);
    }
}
