package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Address {
    @NonNull
    private String country;
    @NonNull
    private String city;
    @NonNull
    private String road;

    public Address() {}

    public Address(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
