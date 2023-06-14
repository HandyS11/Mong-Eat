package com.mongeat.codec;

import com.mongeat.entities.ArticleEntity;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.jetbrains.annotations.NotNull;

public class ArticleCodec implements Codec<ArticleEntity> {
    private final Codec<Document> documentCodec;

    public ArticleCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, @NotNull ArticleEntity article, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", article.getObjectId());
        doc.put("name", article.getName());
        doc.put("image", article.getImage());
        doc.put("price", article.getPrice());

        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<ArticleEntity> getEncoderClass() {
        return ArticleEntity.class;
    }

    @Override
    public ArticleEntity decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        ArticleEntity article = new ArticleEntity();

        article.setId(document.getObjectId("_id").toString());
        article.setName(document.getString("name"));
        article.setImage(document.getString("image"));
        article.setPrice(document.getDouble("price"));

        return article;
    }
}
