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

import java.util.List;

/**
 * UserService
 */
@Singleton
public class UserService extends GenericService<User, NewUser, UserEntity> {
    @Inject
    UserRepository userRepository;

    /**
     * Initializes the service.
     */
    @PostConstruct
    public void init() {
        setRepository(userRepository);
        setConverter(new UserConverter());
        setAddConverter(new NewUserConverter());
    }

    /**
     * Retrieves an user by its name.
     *
     * @param name The name of the user to retrieve.
     * @return A list of users with the given name.
     */
    public List<User> findByName(String name) {
        return userRepository.findByName(name).stream().map(a -> converter.toModel(a)).collect(java.util.stream.Collectors.toList());
    }
}
