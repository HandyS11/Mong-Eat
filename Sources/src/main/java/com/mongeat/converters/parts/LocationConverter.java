package com.mongeat.converters.parts;

import com.mongeat.entities.parts.LocationEntity;
import com.mongeat.models.parts.Location;

/**
 * Converts a Location to a LocationEntity
 */
public class LocationConverter {

    /**
     * Converts a LocationEntity object to a Location object.
     *
     * @param locationEntity The LocationEntity object to convert.
     * @return The Location object.
     */
    public static Location toModel(LocationEntity locationEntity) {
        Location location = new Location();
        location.setAddress(AddressConverter.toModel(locationEntity.getAddress()));
        location.setPoint(PointConverter.toModel(locationEntity.getPoint()));
        return location;
    }

    /**
     * Converts a Location object to a LocationEntity object.
     *
     * @param location The Location object to convert.
     * @return The LocationEntity object.
     */
    public static LocationEntity toEntity(Location location) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setAddress(AddressConverter.toEntity(location.getAddress()));
        locationEntity.setPoint(PointConverter.toEntity(location.getPoint()));
        return locationEntity;
    }
}
