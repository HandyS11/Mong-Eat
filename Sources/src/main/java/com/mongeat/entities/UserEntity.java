package com.mongeat.entities;

import com.mongeat.entities.parts.LocationEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserEntity extends GenericEntity {
    public static final String COLLECTION_NAME = "users";

    private String firstName;
    private String lastName;
    private List<LocationEntity> locations = new ArrayList<>();

    public UserEntity() {
        super(new ObjectId().toHexString());
    }

    public UserEntity(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity(String id, String firstName, String lastName, List<LocationEntity> location) {
        this(id, firstName, lastName);
        this.locations.addAll(location);
    }
}
