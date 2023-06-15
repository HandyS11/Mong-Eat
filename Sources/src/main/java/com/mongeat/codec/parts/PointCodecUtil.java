package com.mongeat.codec.parts;

import com.mongeat.entities.parts.PointEntity;
import org.bson.Document;

public class PointCodecUtil {
    public static PointEntity extractPoint(Document pointDoc) {
        PointEntity p = new PointEntity();

        p.setX(pointDoc.getDouble("x"));
        p.setY(pointDoc.getDouble("y"));

        return p;
    }
}
