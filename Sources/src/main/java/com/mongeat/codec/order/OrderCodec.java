package com.mongeat.codec.order;

import com.mongeat.codec.GenericCodec;
import com.mongeat.entities.Order;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class OrderCodec extends GenericCodec<Order> {
    private final Codec<Document> documentCodec;

    public OrderCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, Order order, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", new ObjectId(order.getId()));
        doc.put("status", order.getStatus());
        doc.put("price", order.getPrice());
        doc.put("tip", order.getTip());
        doc.put("reduction", order.getReduction());
        doc.put("fee", order.getFee());
        //TODO: add articles ids
        doc.put("owner", order.getOwner());
        //TODO: add location

        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<Order> getEncoderClass() {
        return Order.class;
    }

    @Override
    public Order decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        Order order = new Order();

        order.setId(document.getObjectId("_id").toString());
        order.setStatus(document.getString("status"));
        order.setPrice(document.getDouble("price"));
        order.setTip(document.getDouble("tip"));
        order.setReduction(document.getDouble("reduction"));
        order.setFee(document.getDouble("fee"));
        //TODO: add articles ids
        order.setOwner(document.getString("owner"));
        //TODO: add location

        return order;
    }
}