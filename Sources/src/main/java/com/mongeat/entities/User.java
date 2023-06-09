package com.mongeat.entities;

import com.mongeat.entities.parts.Location;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User extends GenericEntity {
    public static final String COLLECTION_NAME = "users";

    private String firstName;
    private String lastName;
    private List<Location> location = new ArrayList<>();

    public User() {
        super(new ObjectId().toHexString());
    }

    public User(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String firstName, String lastName, List<Location> location) {
        this(id, firstName, lastName);
        this.location.addAll(location);
    }
}
