package com.mongeat.converters.parts;

import com.mongeat.entities.parts.AddressEntity;
import com.mongeat.models.parts.Address;

public class AddressConverter {

    public static Address toModel(AddressEntity addressEntity) {
        Address address = new Address();
        address.setCountry(addressEntity.getCountry());
        address.setCity(addressEntity.getCity());
        address.setRoad(addressEntity.getRoad());
        return address;
    }

    public static AddressEntity toEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCity(address.getCity());
        addressEntity.setRoad(address.getRoad());
        return addressEntity;
    }
}
