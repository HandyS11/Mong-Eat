package com.mongeat.repositories;

import com.mongeat.entities.UserEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.or;

/**
 * UserRepository
 */
@Singleton
public class UserRepository extends GenericRepository<UserEntity> {

    /**
     * @return The collection of the model
     */
    @Override
    public MongoCollection<UserEntity> getCollection() {
        return database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class);
    }

    /**
     * Look for users by name
     *
     * @param name Name of the user
     * @return List of users
     */
    public List<UserEntity> findByName(String name) {
        Bson filter = Filters.or(
                Filters.regex("firstName", name.trim(), "i"),
                Filters.regex("lastName", name.trim(), "i")
        );
        return getCollection().find(or(filter)).into(new ArrayList<>());
    }
}
