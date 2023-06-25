package com.mongeat.repositories;

import com.mongeat.codec.ArticleCodec;
import com.mongeat.codec.OrderCodec;
import com.mongeat.codec.RestaurantCodec;
import com.mongeat.codec.UserCodec;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.eclipse.microprofile.config.ConfigProvider;

/**
 * BaseRepository
 */
@ApplicationScoped
public abstract class BaseRepository {
    private final String DB_NAME = ConfigProvider.getConfig().getValue("quarkus.mongodb.database", String.class);
    private final String CONNECTION_STRING = ConfigProvider.getConfig().getValue("quarkus.mongodb.connection-string", String.class);

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
