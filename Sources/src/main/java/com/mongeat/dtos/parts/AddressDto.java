package com.mongeat.dtos.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for address
 */
@Getter
@Setter
@RegisterForReflection
public class AddressDto {
    private String country;
    private String city;
    private String road;
}
