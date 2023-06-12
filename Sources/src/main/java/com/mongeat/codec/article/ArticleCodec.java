package com.mongeat.codec.article;

import com.mongeat.codec.GenericCodec;
import com.mongeat.entities.Article;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

public class ArticleCodec extends GenericCodec<Article> {
    private final Codec<Document> documentCodec;

    public ArticleCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, @NotNull Article article, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", new ObjectId(article.getId()));
        doc.put("name", article.getName());
        doc.put("image", article.getImage());
        doc.put("price", article.getPrice());

        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<Article> getEncoderClass() {
        return Article.class;
    }

    @Override
    public Article decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        Article article = new Article();

        article.setId(document.getObjectId("_id").toString());
        article.setName(document.getString("name"));
        article.setImage(document.getString("image"));
        article.setPrice(document.getDouble("price"));

        return article;
    }
}
