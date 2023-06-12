package com.mongeat.codec.user;

import com.mongeat.codec.GenericCodec;
import com.mongeat.entities.User;
import com.mongeat.entities.parts.Location;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.util.List;

public class UserCodec extends GenericCodec<User> {
    private final Codec<Document> documentCodec;

    public UserCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, User entity, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", new ObjectId(entity.getId()));
        doc.put("firstname", entity.getFirstName());
        doc.put("lastname", entity.getLastName());

        List<Location> location = entity.getLocation();
        List<Document> locationDoc = null;

        //TODO: add locations

        doc.put("location", locationDoc);

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
        //TODO: add locations

        return user;
    }
}
