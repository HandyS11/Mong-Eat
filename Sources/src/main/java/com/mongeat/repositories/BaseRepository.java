package com.mongeat.repositories;

import com.mongeat.codec.article.ArticleCodecProvider;
import com.mongeat.codec.order.OrderCodecProvider;
import com.mongeat.codec.restaurant.RestaurantCodecProvider;
import com.mongeat.codec.user.UserCodecProvider;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public abstract class BaseRepository {
    static final String DB_NAME = "MongEat";
    static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public final MongoDatabase database;

    protected BaseRepository() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()),
                fromProviders(new RestaurantCodecProvider()),
                fromProviders(new ArticleCodecProvider()),
                fromProviders(new UserCodecProvider()),
                fromProviders(new OrderCodecProvider())
        );

        database = MongoClients.create(CONNECTION_STRING)
                               .getDatabase(DB_NAME)
                               .withCodecRegistry(pojoCodecRegistry);
    }
}
