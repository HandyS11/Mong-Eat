package com.mongeat.dtos.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for location
 */
@Getter
@Setter
@RegisterForReflection
public class LocationDto {
    private AddressDto address;
    private PointDto point;
}
