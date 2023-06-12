package com.mongeat.codec.restaurant;

import com.mongeat.entities.Restaurant;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class RestaurantCodecProvider implements CodecProvider {
    @Nullable
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz.equals(Restaurant.class)) {
            return (Codec<T>) new RestaurantCodec();
        }
        return null;
    }
}
