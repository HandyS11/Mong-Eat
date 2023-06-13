package com.mongeat.stub;

import com.mongeat.entities.parts.Address;
import com.mongeat.entities.parts.Location;
import com.mongeat.entities.parts.Point;

import java.util.ArrayList;
import java.util.List;

public class LocationStub {
    public static final Location location1 = new Location(new Point(-4.443184, 57.306340), new Address("United-Kingdom", "Loch Ness", "Inverness IV63 7YD"));
    public static final Location location2 = new Location(new Point(57.306340, -4.443184), new Address("France", "Paris", "Boulevard des champs élysées"));

    protected static final List<Location> locations = new ArrayList<>() {
        {
            add(location1);
            add(location2);
        }
    };
}
