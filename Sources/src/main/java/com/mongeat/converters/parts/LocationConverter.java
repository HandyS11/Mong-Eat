package com.mongeat.converters.parts;

import com.mongeat.entities.parts.LocationEntity;
import com.mongeat.models.parts.Location;

public class LocationConverter {

    public static Location toModel(LocationEntity locationEntity) {
        Location location = new Location();
        location.setAddress(AddressConverter.toModel(locationEntity.getAddress()));
        location.setPoint(PointConverter.toModel(locationEntity.getPoint()));
        return location;
    }

    public static LocationEntity toEntity(Location location) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setAddress(AddressConverter.toEntity(location.getAddress()));
        locationEntity.setPoint(PointConverter.toEntity(location.getPoint()));
        return locationEntity;
    }
}
