package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDto {
    private double x;
    private double y;

    public PointDto() { }

    public PointDto(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
