package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * LocationEntity
 */
@Getter
@Setter
public class LocationEntity {
    private PointEntity point;
    private AddressEntity address;

    public LocationEntity() {}

    /**
     * @param point PointEntity
     * @param address AddressEntity
     */
    public LocationEntity(PointEntity point, AddressEntity address) {
        this.point = point;
        this.address = address;
    }
}
