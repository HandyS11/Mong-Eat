package com.mongeat.codec.parts;

import com.mongeat.entities.parts.AddressEntity;
import org.bson.Document;

/**
 * Utility class for AddressEntity
 */
public class AddressCodecUtil {

    /**
     * Extracts an AddressEntity from a Document
     * @param addressDoc the Document to extract from
     * @return the AddressEntity
     */
    public static AddressEntity extractAddress(Document addressDoc) {
        AddressEntity a = new AddressEntity();

        a.setCountry(addressDoc.getString("country"));
        a.setCity(addressDoc.getString("city"));
        a.setRoad(addressDoc.getString("road"));

        return a;
    }
}
