package com.mongeat.converters;

import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.UserEntity;
import com.mongeat.models.User;

public class UserConverter implements IConverter<User, UserEntity> {
    @Override
    public UserEntity toEntity(User object) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(object.getId());
        userEntity.setFirstName(object.getFirstName());
        userEntity.setLastName(object.getLastName());
        userEntity.setLocations(object.getLocations().stream().map(LocationConverter::toEntity).collect(java.util.stream.Collectors.toList()));
        return userEntity;
    }

    @Override
    public User toModel(UserEntity object) {
        User user = new User();
        user.setId(object.getId());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setLocations(object.getLocations().stream().map(LocationConverter::toModel).collect(java.util.stream.Collectors.toList()));
        return user;
    }
}
