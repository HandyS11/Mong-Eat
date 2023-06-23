package com.mongeat.codec;

import com.mongeat.codec.parts.LocationCodecUtil;
import com.mongeat.entities.OrderEntity;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for OrderEntity
 */
public class OrderCodec implements Codec<OrderEntity> {
    private final Codec<Document> documentCodec;

    /**
     * Constructor
     */
    public OrderCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    /**
     * Encode a OrderEntity into a Document
     * @param writer the writer to use
     * @param order the OrderEntity to encode
     * @param encoderContext the encoder context to use
     */
    @Override
    public void encode(BsonWriter writer, OrderEntity order, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", order.getObjectId());
        doc.put("status", order.getStatus());
        doc.put("price", order.getPrice());
        doc.put("tip", order.getTip());
        doc.put("reduction", order.getReduction());
        doc.put("fee", order.getFee());
        doc.put("articles", order.getArticles().stream().map(ObjectId::new).collect(Collectors.toList()));
        doc.put("owner", new ObjectId(order.getOwner()));
        doc.put("location", LocationCodecUtil.insertLocation(order.getLocation()));

        documentCodec.encode(writer, doc, encoderContext);
    }

    /**
     * Get the class of the encoded object
     * @return the class of the encoded object
     */
    @Override
    public Class<OrderEntity> getEncoderClass() {
        return OrderEntity.class;
    }

    /**
     * Decode a Document into a OrderEntity
     * @param reader the reader to use
     * @param decoderContext the decoder context to use
     * @return the OrderEntity decoded
     */
    @Override
    public OrderEntity decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        OrderEntity order = new OrderEntity();

        order.setId(document.getObjectId("_id").toString());
        order.setStatus(document.getString("status"));
        order.setPrice(document.getDouble("price"));
        order.setTip(document.getDouble("tip"));
        order.setReduction(document.getDouble("reduction"));
        order.setFee(document.getDouble("fee"));

        List<String> articlesId = document.getList("articles", ObjectId.class)
                .stream()
                .map(ObjectId::toString)
                .collect(Collectors.toList());
        order.setArticles(articlesId);

        order.setOwner(document.getObjectId("owner").toString());

        Document location = (Document) document.get("location");
        order.setLocation(LocationCodecUtil.extractLocation(location));

        return order;
    }
}