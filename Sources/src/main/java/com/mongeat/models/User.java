package com.mongeat.models;

import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User extends GenericModel {
    private String firstName;
    private String lastName;
    private List<Location> locations = new ArrayList<>();

    public User() { }

    public User(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String firstName, String lastName, List<Location> locations) {
        this(id, firstName, lastName);
        this.locations.addAll(locations);
    }
}
