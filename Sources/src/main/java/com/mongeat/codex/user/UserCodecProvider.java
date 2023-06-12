package com.mongeat.codex.user;

import com.mongeat.entities.User;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class UserCodecProvider implements CodecProvider {
    @Nullable
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz.equals(User.class)) {
            return (Codec<T>) new UserCodec();
        }
        return null;
    }
}
