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
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

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

    @GET
    @Path("/byName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name) {
        List<User> users = userService.findByName(name);
        if (!users.isEmpty()) {
            return Response.ok(users.stream().map(u -> mapper.toDto(u)).collect(Collectors.toList())).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User with name " + name + " not found")
                    .build();
        }
    }
}
