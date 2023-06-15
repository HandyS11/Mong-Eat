package com.mongeat.models.parts;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private Address address;
    private Point point;

    public Location() {}

    public Location(Point point, Address address) {
        this.point = point;
        this.address = address;
    }
}
