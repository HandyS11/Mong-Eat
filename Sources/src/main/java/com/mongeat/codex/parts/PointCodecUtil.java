package com.mongeat.codex.parts;

import com.mongeat.entities.parts.Point;
import org.bson.Document;

public class PointCodecUtil {
    public static Point extractPoint(Document pointDoc) {
        Point p = new Point();

        p.setX(pointDoc.getDouble("x"));
        p.setY(pointDoc.getDouble("y"));

        return p;
    }
}
