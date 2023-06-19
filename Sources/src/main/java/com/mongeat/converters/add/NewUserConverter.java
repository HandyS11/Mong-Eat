package com.mongeat.converters.add;

import com.mongeat.converters.IConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.UserEntity;
import com.mongeat.models.add.NewUser;

public class NewUserConverter implements IConverter<NewUser, UserEntity> {

    @Override
    public UserEntity toEntity(NewUser object) {
        if (object == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(object.getFirstName());
        userEntity.setLastName(object.getLastName());
        userEntity.setLocations(object.getLocations().stream().map(LocationConverter::toEntity).collect(java.util.stream.Collectors.toList()));
        return userEntity;
    }

    @Override
    public NewUser toModel(UserEntity object) {
        if (object == null) {
            return null;
        }
        NewUser user = new NewUser();
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setLocations(object.getLocations().stream().map(LocationConverter::toModel).collect(java.util.stream.Collectors.toList()));
        return user;
    }
}
