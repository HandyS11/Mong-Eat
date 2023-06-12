package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Location {
    @NonNull
    private Point point;
    @NonNull
    private Address address;

    public Location() {}

    public Location(Point point, Address address) {
        this.point = point;
        this.address = address;
    }
}
