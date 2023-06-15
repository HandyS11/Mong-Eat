package com.mongeat.repositories;

import com.mongeat.entities.RestaurantEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class RestaurantRepository extends GenericRepository<RestaurantEntity> {

    @Override
    public MongoCollection<RestaurantEntity> getCollection() {
        return database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class);
    }
}
