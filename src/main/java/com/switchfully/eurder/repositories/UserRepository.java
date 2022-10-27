package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private ConcurrentHashMap<String, User> userDatabase;

    public void save(User newUser) {
        userDatabase.put(newUser.getPhoneNumber(), newUser);
    }

    public UserRepository() {
        userDatabase = new ConcurrentHashMap<String, User>();
    }

    public ConcurrentHashMap<String, User> getUserDatabase() {
        return userDatabase;
    }
}
