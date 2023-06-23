package com.mongeat.repositories;

import com.mongeat.entities.RestaurantEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RestaurantRepository extends GenericRepository<RestaurantEntity> {

    @Override
    public MongoCollection<RestaurantEntity> getCollection() {
        return database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class);
    }

    public List<RestaurantEntity> findByName(String name) {
        Bson filter = Filters.regex("name", name.trim(), "i");
        return getCollection().find(filter).into(new ArrayList<>());
    }
}
