package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private Point point;
    private Address address;

    public Location() {}

    public Location(Point point, Address address) {
        this.point = point;
        this.address = address;
    }
}
