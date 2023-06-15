package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.PointDto;
import com.mongeat.models.parts.Point;

public class PointMapper {

    public static Point toModel(PointDto pointDto) {
        Point point = new Point();
        point.setX(pointDto.getX());
        point.setY(pointDto.getY());
        return point;
    }

    public static PointDto toDto(Point point) {
        PointDto pointDto = new PointDto();
        pointDto.setX(point.getX());
        pointDto.setY(point.getY());
        return pointDto;
    }
}
