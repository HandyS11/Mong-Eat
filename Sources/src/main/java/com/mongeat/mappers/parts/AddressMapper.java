package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.AddressDto;
import com.mongeat.models.parts.Address;

/**
 * Map Address to AddressDto and vice versa
 */
public class AddressMapper {

    /**
     * Map AddressDto to Address
     * @param addressDto AddressDto
     * @return Address
     */
    public static Address toModel(AddressDto addressDto) {
        Address address = new Address();
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setRoad(addressDto.getRoad());
        return address;
    }

    /**
     * Map Address to AddressDto
     * @param address Address
     * @return AddressDto
     */
    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setRoad(address.getRoad());
        return addressDto;
    }
}
