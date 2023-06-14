package com.mongeat.stub;

import com.mongeat.entities.parts.AddressEntity;
import com.mongeat.entities.parts.LocationEntity;
import com.mongeat.entities.parts.PointEntity;

import java.util.ArrayList;
import java.util.List;

public class LocationStub {
    public static final LocationEntity location1 = new LocationEntity(new PointEntity(-4.443184, 57.306340), new AddressEntity("United-Kingdom", "Loch Ness", "Inverness IV63 7YD"));
    public static final LocationEntity location2 = new LocationEntity(new PointEntity(57.306340, -4.443184), new AddressEntity("France", "Paris", "Boulevard des champs élysées"));

    protected static final List<LocationEntity> locations = new ArrayList<>() {
        {
            add(location1);
            add(location2);
        }
    };
}
