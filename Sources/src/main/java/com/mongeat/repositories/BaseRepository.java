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
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * BaseRepository
 */
public abstract class BaseRepository {
    @ConfigProperty(name = "greeting.message", defaultValue = "MongEat")
    String DB_NAME;

    @ConfigProperty(name = "quarkus.mongodb.connection-string", defaultValue = "mongodb://localhost:27017")
    String CONNECTION_STRING;

    public final MongoDatabase database;

    /**
     * Constructor
     */
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
