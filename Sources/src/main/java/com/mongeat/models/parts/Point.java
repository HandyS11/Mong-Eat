package com.mongeat.models.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * Point
 */
@Getter
@Setter
@RegisterForReflection
public class Point {
    private Double x;
    private Double y;

    public Point() {}

    /**
     * @param x X coordinate of the point
     * @param y Y coordinate of the point
     */
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
