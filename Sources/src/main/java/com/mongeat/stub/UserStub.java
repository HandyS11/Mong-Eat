package com.mongeat.stub;

import com.mongeat.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserStub {
    private List<User> users = new ArrayList<>();

    public  UserStub() {
        User user1 = new User("647063c7e4314fe5feca99f2", "Valentin", "Clergue", LocationStub.locations);
        User user2 = new User("647063cc67e91803a0f73cc6", "Mathis", "Ribémont", LocationStub.locations);
        User user3 = new User("647063e6e6de03f52dff3590", "Benjamin", "Valleix", LocationStub.locations);
        User user4 = new User("6470641c251dad7b4fc1dc00", "Marc", "Chevaldonné", LocationStub.locations);
        User user5 = new User("6470645ef433da93dfbdc88b", "Yohan", "Breuil", LocationStub.locations);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public List<User> getUsers() {
        return users;
    }
}
