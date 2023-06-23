package com.mongeat.entities;

import com.mongeat.entities.parts.LocationEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * UserEntity
 */
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

    /**
     * @param id Id of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     */
    public UserEntity(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @param id Id of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param location List of locations
     */
    public UserEntity(String id, String firstName, String lastName, List<LocationEntity> location) {
        this(id, firstName, lastName);
        this.locations.addAll(location);
    }
}
