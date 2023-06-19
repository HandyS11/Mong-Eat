package com.mongeat.models.add;

import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewUser {
    private String firstName;
    private String lastName;
    private List<Location> locations = new ArrayList<>();

    public NewUser() { }

    public NewUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NewUser(String firstName, String lastName, List<Location> locations) {
        this(firstName, lastName);
        this.locations.addAll(locations);
    }
}
