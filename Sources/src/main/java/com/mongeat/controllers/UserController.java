package com.mongeat.controllers;

import com.mongeat.entities.User;
import com.mongeat.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController extends GenericController<User> {

    @Inject
    UserService userService;

    @PostConstruct
    public void init() {
        setService(userService);
    }
}
