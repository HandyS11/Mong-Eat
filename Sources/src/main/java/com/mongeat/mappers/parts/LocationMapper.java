package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.LocationDto;
import com.mongeat.models.parts.Location;

public class LocationMapper {

    public static Location mapToLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setAddress(AddressMapper.mapToAddress(locationDto.getAddress()));
        location.setPoint(PointMapper.mapToPoint(locationDto.getPoint()));
        return location;
    }

    public static LocationDto mapToLocationDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setAddress(AddressMapper.mapToAddressDto(location.getAddress()));
        locationDto.setPoint(PointMapper.mapToPointDto(location.getPoint()));
        return locationDto;
    }
}
