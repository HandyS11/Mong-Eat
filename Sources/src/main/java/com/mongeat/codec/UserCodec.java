package com.mongeat.codec;

import com.mongeat.codec.parts.LocationCodecUtil;
import com.mongeat.entities.UserEntity;
import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Codec for the UserEntity class.
 */
public class UserCodec implements Codec<UserEntity> {
    private final Codec<Document> documentCodec;

    /**
     * Constructor.
     */
    public UserCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    /**
     * Encode a UserEntity into a Document.
     * @param writer the writer to use
     * @param user the UserEntity to encode
     * @param encoderContext the encoder context to use
     */
    @Override
    public void encode(BsonWriter writer, UserEntity user, EncoderContext encoderContext) {
        Document doc = new Document();

        doc.put("_id", user.getObjectId());
        doc.put("firstname", user.getFirstName());
        doc.put("lastname", user.getLastName());
        doc.put("locations", user.getLocations().stream().map(LocationCodecUtil::insertLocation).collect(Collectors.toList()));

        documentCodec.encode(writer, doc, encoderContext);
    }

    /**
     * Get the class of the encoded object.
     * @return the class of the encoded object
     */
    @Override
    public Class<UserEntity> getEncoderClass() {
        return UserEntity.class;
    }

    /**
     * Decode a Document into a UserEntity.
     * @param reader the reader to use
     * @param decoderContext the decoder context to use
     * @return the decoded UserEntity
     */
    @Override
    public UserEntity decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        UserEntity user = new UserEntity();

        user.setId(document.getObjectId("_id").toString());
        user.setFirstName(document.getString("firstname"));
        user.setLastName(document.getString("lastname"));

        List<Document> locations = document.getList("locations", Document.class);
        user.setLocations(locations.stream().map(LocationCodecUtil::extractLocation).collect(Collectors.toList()));

        return user;
    }
}
