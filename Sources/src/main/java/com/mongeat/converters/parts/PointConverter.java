package com.mongeat.converters.parts;

import com.mongeat.entities.parts.PointEntity;
import com.mongeat.models.parts.Point;

public class PointConverter {

    public static Point toModel(PointEntity pointEntity) {
        Point point = new Point();
        point.setX(pointEntity.getX());
        point.setY(pointEntity.getY());
        return point;
    }

    public static PointEntity toEntity(Point point) {
        PointEntity pointEntity = new PointEntity();
        pointEntity.setX(point.getX());
        pointEntity.setY(point.getY());
        return pointEntity;
    }
}
