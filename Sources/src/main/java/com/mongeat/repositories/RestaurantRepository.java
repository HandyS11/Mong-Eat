package com.mongeat.repositories;

import com.mongeat.entities.RestaurantEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * RestaurantRepository
 */
@Singleton
public class RestaurantRepository extends GenericRepository<RestaurantEntity> {

    /**
     * @return The collection of the model
     */
    @Override
    public MongoCollection<RestaurantEntity> getCollection() {
        return database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class);
    }

    /**
     * Look for restaurants by name
     *
     * @param name Name of the restaurant
     * @return List of restaurants
     */
    public List<RestaurantEntity> findByName(String name) {
        Bson filter = Filters.regex("name", name.trim(), "i");
        return getCollection().find(filter).into(new ArrayList<>());
    }
}
