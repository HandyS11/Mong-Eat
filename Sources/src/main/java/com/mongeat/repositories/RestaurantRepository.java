package com.mongeat.repositories;

import com.mongeat.entities.Restaurant;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class RestaurantRepository extends BaseRepository<Restaurant> {

    @Override
    public MongoCollection<Restaurant> getCollection() {
        return database.getCollection(Restaurant.COLLECTION_NAME, Restaurant.class);
    }
}
