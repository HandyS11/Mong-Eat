package com.mongeat.codec;

import com.mongeat.codec.parts.LocationCodecUtil;
import com.mongeat.entities.User;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.List;
import java.util.stream.Collectors;

public class UserCodec implements Codec<User> {
    private final Codec<Document> documentCodec;

    public UserCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, User user, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", user.getObjectId());
        doc.put("firstname", user.getFirstName());
        doc.put("lastname", user.getLastName());
        doc.put("locations", user.getLocation().stream().map(LocationCodecUtil::insertLocation).collect(Collectors.toList()));

        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<User> getEncoderClass() {
        return User.class;
    }

    @Override
    public User decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        User user = new User();

        user.setId(document.getObjectId("_id").toString());
        user.setFirstName(document.getString("firstname"));
        user.setLastName(document.getString("lastname"));

        List<Document> locations = document.getList("locations", Document.class);
        user.setLocation(locations.stream().map(LocationCodecUtil::extractLocation).collect(Collectors.toList()));

        return user;
    }
}
