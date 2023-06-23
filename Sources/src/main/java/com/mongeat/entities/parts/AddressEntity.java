package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.Setter;

/**
 * AddressEntity
 */
@Getter
@Setter
public class AddressEntity {
    private String country;
    private String city;
    private String road;

    public AddressEntity() {}

    /**
     * @param country Country name
     * @param city Name of the city
     * @param road Name of the road
     */
    public AddressEntity(String country, String city, String road) {
        this.country = country;
        this.city = city;
        this.road = road;
    }
}
