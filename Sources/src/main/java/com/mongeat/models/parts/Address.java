package com.mongeat.models.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * Address
 */
@Getter
@Setter
public class Address {
    private String country;
    private String city;
    private String road;

    public Address() {}

    /**
     * @param country Country of the address
     * @param city City of the address
     * @param road Road of the address
     */
    public Address(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
