package com.mongeat.controllers;

import com.mongeat.dtos.UserDto;
import com.mongeat.entities.UserEntity;
import com.mongeat.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserController extends GenericController<UserEntity, UserDto> {

    @Inject
    UserService userService;

    public UserController() {
        super(UserDto.class);
    }

    @PostConstruct
    public void init() {
        setService(userService);
    }
}
