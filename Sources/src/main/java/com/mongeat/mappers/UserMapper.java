package com.mongeat.mappers;

import com.mongeat.dtos.UserDto;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.User;

import java.util.stream.Collectors;

/**
 * Map User to UserDto and vice versa
 */
public class UserMapper implements IMapper<User, UserDto> {

    /**
     * Map User to UserDto
     * @param object User
     * @return UserDto
     */
    @Override
    public UserDto toDto(User object) {
        UserDto userDto = new UserDto();
        userDto.setId(object.getId());
        userDto.setFirstName(object.getFirstName());
        userDto.setLastName(object.getLastName());
        userDto.setLocations(object.getLocations().stream().map(LocationMapper::toDto).collect(Collectors.toList()));
        return userDto;
    }

    /**
     * Map UserDto to User
     * @param object UserDto
     * @return User
     */
    @Override
    public User toModel(UserDto object) {
        User user = new User();
        user.setId(object.getId());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setLocations(object.getLocations().stream().map(LocationMapper::toModel).collect(Collectors.toList()));
        return user;
    }
}
