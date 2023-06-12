package com.mongeat.codex.article;

import com.mongeat.entities.Article;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class ArticleCodecProvider implements CodecProvider {

    @Nullable
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz.equals(Article.class)) {
            return (Codec<T>) new ArticleCodec();
        }
        return null;
    }
}
