package com.mongeat.services;

import com.mongeat.converters.UserConverter;
import com.mongeat.converters.add.NewUserConverter;
import com.mongeat.entities.UserEntity;
import com.mongeat.models.User;
import com.mongeat.models.add.NewUser;
import com.mongeat.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserService extends GenericService<User, NewUser, UserEntity> {
    @Inject
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        setRepository(userRepository);
        setConverter(new UserConverter());
        setAddConverter(new NewUserConverter());
    }
}
