package com.mongeat.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class BaseRepository {
    final String DB_NAME = "MongEat";
    final String CONNECTION_STRING = "mongodb://localhost:27017";

    public MongoDatabase database = MongoClients.create(CONNECTION_STRING).getDatabase(DB_NAME);
}
