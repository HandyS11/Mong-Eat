package com.mongeat.codec.parts;

import com.mongeat.entities.parts.AddressEntity;
import org.bson.Document;

public class AddressCodecUtil {
    public static AddressEntity extractAddress(Document addressDoc) {
        AddressEntity a = new AddressEntity();

        a.setCountry(addressDoc.getString("country"));
        a.setCity(addressDoc.getString("city"));
        a.setRoad(addressDoc.getString("road"));

        return a;
    }
}
