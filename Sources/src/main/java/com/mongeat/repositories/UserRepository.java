package com.mongeat.repositories;

import com.mongeat.entities.UserEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.regex;

@Singleton
public class UserRepository extends GenericRepository<UserEntity> {

    @Override
    public MongoCollection<UserEntity> getCollection() {
        return database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class);
    }

    public UserEntity findByName(String name) {
        return getCollection().find(or(
                regex("firstName", name, "i"),
                regex("lastName", name, "i")
        )).first();
    }
}
