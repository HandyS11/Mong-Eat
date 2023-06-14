package com.mongeat.controllers;

import com.mongeat.dtos.UserDto;
import com.mongeat.entities.User;
import com.mongeat.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserController extends GenericController<User, UserDto> {

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
