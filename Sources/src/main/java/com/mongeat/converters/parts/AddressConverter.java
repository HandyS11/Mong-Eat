package com.mongeat.converters.parts;

import com.mongeat.entities.parts.AddressEntity;
import com.mongeat.models.parts.Address;

/**
 * Converts an Address to an AddressEntity
 */
public class AddressConverter {

    /**
     * Converts an AddressEntity object to an Address object.
     *
     * @param addressEntity The AddressEntity object to convert.
     * @return The Address object.
     */
    public static Address toModel(AddressEntity addressEntity) {
        Address address = new Address();
        address.setCountry(addressEntity.getCountry());
        address.setCity(addressEntity.getCity());
        address.setRoad(addressEntity.getRoad());
        return address;
    }

    /**
     * Converts an Address object to an AddressEntity object.
     *
     * @param address The Address object to convert.
     * @return The AddressEntity object.
     */
    public static AddressEntity toEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCity(address.getCity());
        addressEntity.setRoad(address.getRoad());
        return addressEntity;
    }
}
