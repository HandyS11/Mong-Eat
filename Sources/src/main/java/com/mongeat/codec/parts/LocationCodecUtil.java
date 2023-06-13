package com.mongeat.codec.parts;

import com.mongeat.entities.parts.Location;
import org.bson.Document;

public class LocationCodecUtil {
    public static Location extractLocation(Document locationDoc) {
        Location l = new Location();

        l.setPoint(PointCodecUtil.extractPoint((Document) locationDoc.get("point")));
        l.setAddress(AddressCodecUtil.extractAddress((Document) locationDoc.get("address")));

        return l;
    }

    public static Document insertLocation(Location l) {
        Document p = new Document();
        p.put("x", l.getPoint().getX());
        p.put("y", l.getPoint().getY());

        Document a = new Document();
        a.put("country", l.getAddress().getCountry());
        a.put("city", l.getAddress().getCity());
        a.put("road", l.getAddress().getRoad());

        Document loc = new Document();
        loc.put("point", p);
        loc.put("address", a);

        return loc;
    }
}
