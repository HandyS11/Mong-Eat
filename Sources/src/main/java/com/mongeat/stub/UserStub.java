package com.mongeat.stub;

import com.mongeat.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserStub {
    private final List<UserEntity> users = new ArrayList<>();

    public  UserStub() {
        UserEntity user1 = new UserEntity("647063c7e4314fe5feca99f2", "Valentin", "Clergue", LocationStub.locations);
        UserEntity user2 = new UserEntity("647063cc67e91803a0f73cc6", "Mathis", "Ribémont", LocationStub.locations);
        UserEntity user3 = new UserEntity("647063e6e6de03f52dff3590", "Benjamin", "Valleix", LocationStub.locations);
        UserEntity user4 = new UserEntity("6470641c251dad7b4fc1dc00", "Marc", "Chevaldonné", LocationStub.locations);
        UserEntity user5 = new UserEntity("6470645ef433da93dfbdc88b", "Yohan", "Breuil", LocationStub.locations);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public List<UserEntity> getUsers() {
        return users;
    }
}
