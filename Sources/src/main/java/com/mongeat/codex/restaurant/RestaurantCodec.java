package com.mongeat.codex.restaurant;

import com.mongeat.codex.GenericCodec;
import com.mongeat.entities.Restaurant;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class RestaurantCodec extends GenericCodec<Restaurant> {
    private final Codec<Document> documentCodec;

    public RestaurantCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, Restaurant entity, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", new ObjectId(entity.getId()));
        doc.put("name", entity.getName());
        doc.put("image", entity.getImage());
        doc.put("rate", entity.getRate());
        //TODO: add articles ids
        //TODO: add category
        //TOTO: add locations
    }

    @Override
    public Class<Restaurant> getEncoderClass() {
        return Restaurant.class;
    }

    @Override
    public Restaurant decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        Restaurant restaurant = new Restaurant();

        restaurant.setId(document.getObjectId("_id").toString());
        restaurant.setName(document.getString("name"));
        restaurant.setImage(document.getString("image"));
        restaurant.setRate(document.getDouble("rate"));
        //TODO: add articles ids
        //TODO: add category
        //TOTO: add locations

        return restaurant;
    }
}
