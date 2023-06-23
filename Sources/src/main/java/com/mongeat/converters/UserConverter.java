package com.mongeat.converters;

import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.UserEntity;
import com.mongeat.models.User;

/**
 * Converts a User to a UserEntity
 */
public class UserConverter implements IConverter<User, UserEntity> {

    /**
     * Converts a User object to a UserEntity object.
     *
     * @param object The User object to convert.
     * @return The UserEntity object.
     */
    @Override
    public UserEntity toEntity(User object) {
        if (object == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(object.getId());
        userEntity.setFirstName(object.getFirstName());
        userEntity.setLastName(object.getLastName());
        userEntity.setLocations(object.getLocations().stream().map(LocationConverter::toEntity).collect(java.util.stream.Collectors.toList()));
        return userEntity;
    }


    /**
     * Converts a UserEntity object to a User object.
     *
     * @param object The UserEntity object to convert.
     * @return The User object.
     */
    @Override
    public User toModel(UserEntity object) {
        if (object == null) {
            return null;
        }
        User user = new User();
        user.setId(object.getId());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setLocations(object.getLocations().stream().map(LocationConverter::toModel).collect(java.util.stream.Collectors.toList()));
        return user;
    }
}
