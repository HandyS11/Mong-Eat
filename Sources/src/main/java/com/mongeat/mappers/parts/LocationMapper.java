package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.LocationDto;
import com.mongeat.models.parts.Location;

public class LocationMapper {

    public static Location toModel(LocationDto locationDto) {
        Location location = new Location();
        location.setAddress(AddressMapper.toModel(locationDto.getAddress()));
        location.setPoint(PointMapper.toModel(locationDto.getPoint()));
        return location;
    }

    public static LocationDto toDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setAddress(AddressMapper.toDto(location.getAddress()));
        locationDto.setPoint(PointMapper.toDto(location.getPoint()));
        return locationDto;
    }
}
