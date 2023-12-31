package com.mongeat.mappers.add;

import com.mongeat.dtos.add.NewUserDto;
import com.mongeat.mappers.IMapper;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.add.NewUser;

import java.util.stream.Collectors;

/**
 * Map NewUser to NewUserDto and vice versa
 */
public class NewUserMapper implements IMapper<NewUser, NewUserDto> {

    /**
     * Map NewUser to NewUserDto
     * @param object NewUser
     * @return NewUserDto
     */
    @Override
    public NewUserDto toDto(NewUser object) {
        NewUserDto userDto = new NewUserDto();
        userDto.setFirstName(object.getFirstName());
        userDto.setLastName(object.getLastName());
        userDto.setLocations(object.getLocations().stream().map(LocationMapper::toDto).collect(Collectors.toList()));
        return userDto;
    }

    /**
     * Map NewUserDto to NewUser
     * @param object NewUserDto
     * @return NewUser
     */
    @Override
    public NewUser toModel(NewUserDto object) {
        NewUser user = new NewUser();
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setLocations(object.getLocations().stream().map(LocationMapper::toModel).collect(Collectors.toList()));
        return user;
    }
}
