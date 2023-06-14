package com.mongeat.repositories;

import com.mongeat.codec.ArticleCodec;
import com.mongeat.codec.OrderCodec;
import com.mongeat.codec.RestaurantCodec;
import com.mongeat.codec.UserCodec;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

public abstract class BaseRepository {
    static final String DB_NAME = "MongEat";
    static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public final MongoDatabase database;

    protected BaseRepository() {
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromCodecs(
                new ArticleCodec(),
                new OrderCodec(),
                new RestaurantCodec(),
                new UserCodec());

        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, pojoCodecRegistry);

        database = MongoClients.create(CONNECTION_STRING)
                               .getDatabase(DB_NAME)
                               .withCodecRegistry(codecRegistry);
    }
}
