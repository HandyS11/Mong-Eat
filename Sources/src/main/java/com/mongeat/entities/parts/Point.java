package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Point {
    @NonNull
    private Double x;
    @NonNull
    private Double y;

    public Point() {}

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
