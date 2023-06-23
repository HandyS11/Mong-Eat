package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for location
 */
@Getter
@Setter
public class LocationDto {
    private AddressDto address;
    private PointDto point;
}
