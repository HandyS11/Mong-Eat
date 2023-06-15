package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressEntity {
    private String country;
    private String city;
    private String road;

    public AddressEntity() {}

    public AddressEntity(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
