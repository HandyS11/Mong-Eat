package com.mongeat.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class User extends GenericEntity {
    public static final String COLLECTION_NAME = "users";

    private String firstName;
    private String lastName;
    private List<Location> location;
}
