package com.mongeat.codec.parts;

import com.mongeat.entities.parts.PointEntity;
import org.bson.Document;

/**
 * Utility class for PointEntity
 */
public class PointCodecUtil {

    /**
     * Extract a PointEntity from a Document
     * @param pointDoc the Document to extract from
     * @return the PointEntity extracted
     */
    public static PointEntity extractPoint(Document pointDoc) {
        PointEntity p = new PointEntity();

        p.setX(pointDoc.getDouble("x"));
        p.setY(pointDoc.getDouble("y"));

        return p;
    }
}
