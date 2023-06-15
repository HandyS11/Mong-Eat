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

public class OrderCodec implements Codec<OrderEntity> {
    private final Codec<Document> documentCodec;

    public OrderCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

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

    @Override
    public Class<OrderEntity> getEncoderClass() {
        return OrderEntity.class;
    }

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