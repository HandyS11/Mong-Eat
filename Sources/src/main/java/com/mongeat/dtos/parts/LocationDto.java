package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    private AddressDto address;
    private PointDto point;

    public LocationDto() { }

    public LocationDto(AddressDto address, PointDto point) {
        this.address = address;
        this.point = point;
    }
}
