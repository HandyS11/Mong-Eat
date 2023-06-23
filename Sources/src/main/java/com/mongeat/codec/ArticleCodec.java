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

/**
 * Utility class for ArticleEntity
 */
public class ArticleCodec implements Codec<ArticleEntity> {
    private final Codec<Document> documentCodec;

    /**
     * Constructor
     */
    public ArticleCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    /**
     * Encode a ArticleEntity into a Document
     * @param writer the writer to use
     * @param article the ArticleEntity to encode
     * @param encoderContext the encoder context to use
     */
    @Override
    public void encode(BsonWriter writer, @NotNull ArticleEntity article, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", article.getObjectId());
        doc.put("name", article.getName());
        doc.put("image", article.getImage());
        doc.put("price", article.getPrice());

        documentCodec.encode(writer, doc, encoderContext);
    }

    /**
     * Get the class of the encoded object
     * @return the class of the encoded object
     */
    @Override
    public Class<ArticleEntity> getEncoderClass() {
        return ArticleEntity.class;
    }

    /**
     * Decode a Document into a ArticleEntity
     * @param reader the reader to use
     * @param decoderContext the decoder context to use
     * @return the ArticleEntity decoded
     */
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
