package com.mongeat.converters.parts;

import com.mongeat.entities.parts.PointEntity;
import com.mongeat.models.parts.Point;

/**
 * Converts a Point to a PointEntity
 */
public class PointConverter {

    /**
     * Converts a PointEntity object to a Point object.
     *
     * @param pointEntity The PointEntity object to convert.
     * @return The Point object.
     */
    public static Point toModel(PointEntity pointEntity) {
        Point point = new Point();
        point.setX(pointEntity.getX());
        point.setY(pointEntity.getY());
        return point;
    }

    /**
     * Converts a Point object to a PointEntity object.
     *
     * @param point The Point object to convert.
     * @return The PointEntity object.
     */
    public static PointEntity toEntity(Point point) {
        PointEntity pointEntity = new PointEntity();
        pointEntity.setX(point.getX());
        pointEntity.setY(point.getY());
        return pointEntity;
    }
}
