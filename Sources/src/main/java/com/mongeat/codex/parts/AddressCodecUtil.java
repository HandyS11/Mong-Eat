package com.mongeat.codex.parts;

import com.mongeat.entities.parts.Address;
import org.bson.Document;

public class AddressCodecUtil {
    public static Address extractAddress(Document addressDoc) {
        Address a = new Address();

        a.setCountry(addressDoc.getString("country"));
        a.setCity(addressDoc.getString("city"));
        a.setRoad(addressDoc.getString("road"));

        return a;
    }
}
