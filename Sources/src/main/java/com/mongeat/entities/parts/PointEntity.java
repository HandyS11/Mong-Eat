package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointEntity {
    private Double x;
    private Double y;

    public PointEntity() {}

    public PointEntity(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
