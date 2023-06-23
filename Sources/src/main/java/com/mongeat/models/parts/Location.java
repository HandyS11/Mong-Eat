package com.mongeat.models.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * Location
 */
@Setter
@Getter
public class Location {
    private Address address;
    private Point point;

    public Location() {}

    /**
     * @param point Point of the location
     * @param address Address of the location
     */
    public Location(Point point, Address address) {
        this.point = point;
        this.address = address;
    }
}
