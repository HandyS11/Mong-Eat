package com.mongeat.models.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {
    private Double x;
    private Double y;

    public Point() {}

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
