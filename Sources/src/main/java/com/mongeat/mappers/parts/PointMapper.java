package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.PointDto;
import com.mongeat.models.parts.Point;

/**
 * Map Point to PointDto and vice versa
 */
public class PointMapper {

    /**
     * Map PointDto to Point
     * @param pointDto PointDto
     * @return Point
     */
    public static Point toModel(PointDto pointDto) {
        Point point = new Point();
        point.setX(pointDto.getX());
        point.setY(pointDto.getY());
        return point;
    }

    /**
     * Map Point to PointDto
     * @param point Point
     * @return PointDto
     */
    public static PointDto toDto(Point point) {
        PointDto pointDto = new PointDto();
        pointDto.setX(point.getX());
        pointDto.setY(point.getY());
        return pointDto;
    }
}
