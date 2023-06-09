package com.mongeat.repositories;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public abstract class BaseRepository {

    final String DB_NAME = "MongEat";   //TODO: move to config
    final String CONNECTION_STRING = "mongodb://localhost:27017";

    public MongoDatabase database;

    public BaseRepository() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        database = MongoClients.create(CONNECTION_STRING).getDatabase(DB_NAME).withCodecRegistry(pojoCodecRegistry);
    }
}
