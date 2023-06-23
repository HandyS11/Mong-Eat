package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * PointEntity
 */
@Getter
@Setter
public class PointEntity {
    private Double x;
    private Double y;

    public PointEntity() {}

    /**
     * @param x X coordinate
     * @param y Y coordinate
     */
    public PointEntity(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}
