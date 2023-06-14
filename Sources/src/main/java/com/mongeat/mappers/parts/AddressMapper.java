package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.AddressDto;
import com.mongeat.models.parts.Address;

public class AddressMapper {

    public static Address toModel(AddressDto addressDto) {
        Address address = new Address();
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setRoad(addressDto.getRoad());
        return address;
    }

    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setRoad(address.getRoad());
        return addressDto;
    }
}
