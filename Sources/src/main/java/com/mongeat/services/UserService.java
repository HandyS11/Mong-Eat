package com.mongeat.services;

import com.mongeat.entities.UserEntity;
import com.mongeat.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserService extends GenericService<UserEntity> {

    @Inject
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        setRepository(userRepository);
    }
}
