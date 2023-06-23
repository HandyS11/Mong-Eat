package com.mongeat.repositories;

import com.mongeat.entities.UserEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.or;

@Singleton
public class UserRepository extends GenericRepository<UserEntity> {

    @Override
    public MongoCollection<UserEntity> getCollection() {
        return database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class);
    }

    public List<UserEntity> findByName(String name) {
        Bson filter = Filters.or(
                Filters.regex("firstName", name.trim(), "i"),
                Filters.regex("lastName", name.trim(), "i")
        );
        return getCollection().find(or(filter)).into(new ArrayList<>());
    }
}
