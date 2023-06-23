package com.mongeat.mappers.parts;

import com.mongeat.dtos.parts.LocationDto;
import com.mongeat.models.parts.Location;

/**
 * Map Location to LocationDto and vice versa
 */
public class LocationMapper {

    /**
     * Map LocationDto to Location
     * @param locationDto LocationDto
     * @return Location
     */
    public static Location toModel(LocationDto locationDto) {
        Location location = new Location();
        location.setAddress(AddressMapper.toModel(locationDto.getAddress()));
        location.setPoint(PointMapper.toModel(locationDto.getPoint()));
        return location;
    }

    /**
     * Map Location to LocationDto
     * @param location Location
     * @return LocationDto
     */
    public static LocationDto toDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setAddress(AddressMapper.toDto(location.getAddress()));
        locationDto.setPoint(PointMapper.toDto(location.getPoint()));
        return locationDto;
    }
}
