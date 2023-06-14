package com.mongeat.dtos.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String country;
    private String city;
    private String road;

    public AddressDto() { }

    public AddressDto(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
