package com.mongeat.services;

import com.mongeat.entities.User;
import com.mongeat.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class UserService extends GenericService<User> {

    @Inject
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        setRepository(userRepository);
    }
}
