package com.mongeat.mappers;

import com.mongeat.dtos.UserDto;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLocations(userDto.getLocations().stream().map(LocationMapper::mapToLocation).collect(Collectors.toList()));
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setLocations(user.getLocations().stream().map(LocationMapper::mapToLocationDto).collect(Collectors.toList()));
        return userDto;
    }
}
