package com.mongeat.repositories;

import com.mongeat.entities.UserEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class UserRepository extends GenericRepository<UserEntity> {

    @Override
    public MongoCollection<UserEntity> getCollection() {
        return database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class);
    }
}
