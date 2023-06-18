package com.mongeat.controllers;

import com.mongeat.dtos.UserDto;
import com.mongeat.dtos.add.NewUserDto;
import com.mongeat.entities.UserEntity;
import com.mongeat.mappers.UserMapper;
import com.mongeat.mappers.add.NewUserMapper;
import com.mongeat.models.User;
import com.mongeat.models.add.NewUser;
import com.mongeat.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserController extends GenericController<UserDto, NewUserDto, User, NewUser, UserEntity> {

    @Inject
    UserService userService;

    @PostConstruct
    public void init() {
        setService(userService);
        setMapper(new UserMapper());
        setPostMapper(new NewUserMapper());
    }
}
