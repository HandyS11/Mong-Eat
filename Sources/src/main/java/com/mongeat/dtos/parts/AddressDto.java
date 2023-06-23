package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for address
 */
@Getter
@Setter
public class AddressDto {
    private String country;
    private String city;
    private String road;
}
