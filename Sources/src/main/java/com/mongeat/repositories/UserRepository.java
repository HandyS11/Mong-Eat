package com.mongeat.repositories;

import com.mongeat.entities.User;
import com.mongodb.client.MongoCollection;

public class UserRepository extends BaseRepository<User> {

    @Override
    public MongoCollection<User> getCollection() {
        return database.getCollection(User.COLLECTION_NAME, User.class);
    }
}
