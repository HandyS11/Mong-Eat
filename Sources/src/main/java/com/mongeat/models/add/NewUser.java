package com.mongeat.models.add;

import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * NewUser
 */
@Getter
@Setter
public class NewUser {
    private String firstName;
    private String lastName;
    private List<Location> locations = new ArrayList<>();

    public NewUser() { }

    /**
     * @param firstName First name of the user
     * @param lastName Last name of the user
     */
    public NewUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param locations Locations of the user
     */
    public NewUser(String firstName, String lastName, List<Location> locations) {
        this(firstName, lastName);
        this.locations.addAll(locations);
    }
}
