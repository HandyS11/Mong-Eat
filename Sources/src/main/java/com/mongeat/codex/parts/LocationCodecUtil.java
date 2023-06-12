package com.mongeat.codex.parts;

import com.mongeat.entities.parts.Location;
import org.bson.Document;

public class LocationCodecUtil {
    public static Location extractLocation(Document locationDoc) {
        Location l = new Location();

        l.setPoint(PointCodecUtil.extractPoint((Document) locationDoc.get("point")));
        l.setAddress(AddressCodecUtil.extractAddress((Document) locationDoc.get("address")));

        return l;
    }
}
