package com.mongeat.repositories;

import com.mongeat.entities.RestaurantEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

import static com.mongodb.client.model.Filters.regex;

@Singleton
public class RestaurantRepository extends GenericRepository<RestaurantEntity> {

    @Override
    public MongoCollection<RestaurantEntity> getCollection() {
        return database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class);
    }

    public RestaurantEntity findByName(String name) {
        return getCollection().find(regex("name", name, "i")).first();
    }
}
