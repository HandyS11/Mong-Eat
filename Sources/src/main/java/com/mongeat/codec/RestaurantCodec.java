package com.mongeat.codec;

import com.mongeat.codec.parts.CategoryCodecUtil;
import com.mongeat.codec.parts.LocationCodecUtil;
import com.mongeat.entities.RestaurantEntity;
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

public class RestaurantCodec implements Codec<RestaurantEntity> {
    private final Codec<Document> documentCodec;

    public RestaurantCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, RestaurantEntity restaurant, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", new ObjectId(restaurant.getId()));
        doc.put("name", restaurant.getName());
        doc.put("image", restaurant.getImage());
        doc.put("rate", restaurant.getRate());
        doc.put("articles", restaurant.getArticles().stream().map(ObjectId::new).collect(Collectors.toList()));
        doc.put("categories", restaurant.getCategories().stream().map(CategoryCodecUtil::insertCategory).collect(Collectors.toList()));
        doc.put("location", LocationCodecUtil.insertLocation(restaurant.getLocation()));

        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<RestaurantEntity> getEncoderClass() {
        return RestaurantEntity.class;
    }

    @Override
    public RestaurantEntity decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        RestaurantEntity restaurant = new RestaurantEntity();

        restaurant.setId(document.getObjectId("_id").toString());
        restaurant.setName(document.getString("name"));
        restaurant.setImage(document.getString("image"));
        restaurant.setRate(document.getDouble("rate"));

        List<String> articlesId = document.getList("articles", ObjectId.class)
                .stream()
                .map(ObjectId::toString)
                .collect(Collectors.toList());
        restaurant.setArticles(articlesId);

        List<Document> categories = document.getList("categories", Document.class);
        restaurant.setCategories(categories.stream().map(CategoryCodecUtil::extractCategory).collect(Collectors.toList()));

        Document location = (Document) document.get("location");
        restaurant.setLocation(LocationCodecUtil.extractLocation(location));

        return restaurant;
    }
}