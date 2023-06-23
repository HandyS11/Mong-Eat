package com.mongeat.models;

import com.mongeat.models.parts.Location;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * User
 */
@Getter
@Setter
@RegisterForReflection
public class User extends GenericModel {
    private String firstName;
    private String lastName;
    private List<Location> locations = new ArrayList<>();

    public User() { }

    /**
     * @param id Id of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     */
    public User(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @param id Id of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param locations Locations of the user
     */
    public User(String id, String firstName, String lastName, List<Location> locations) {
        this(id, firstName, lastName);
        this.locations.addAll(locations);
    }
}
