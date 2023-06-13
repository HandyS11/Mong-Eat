package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String country;
    private String city;
    private String road;

    public Address() {}

    public Address(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
