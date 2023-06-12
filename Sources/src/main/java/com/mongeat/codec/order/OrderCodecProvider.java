package com.mongeat.codec.order;

import com.mongeat.entities.Order;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class OrderCodecProvider implements CodecProvider {
    @Nullable
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry codecRegistry) {
        if (clazz.equals(Order.class)) {
            return (Codec<T>) new OrderCodec();
        }
        return null;
    }
}
