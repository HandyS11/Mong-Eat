package com.mongeat.entities;

import com.mongeat.entities.parts.Location;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User extends GenericEntity {
    public static final String COLLECTION_NAME = "users";

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private List<Location> location = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, List<Location> location) {
        this(firstName, lastName);
        this.location.addAll(location);
    }
}
