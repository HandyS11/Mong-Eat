package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationEntity {
    private PointEntity point;
    private AddressEntity address;

    public LocationEntity() {}

    public LocationEntity(PointEntity point, AddressEntity address) {
        this.point = point;
        this.address = address;
    }
}
