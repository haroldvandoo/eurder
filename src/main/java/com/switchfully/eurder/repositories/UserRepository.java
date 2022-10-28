package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.security.Role;
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
        save(new User("Tom", "Jansens", "tomjansens@hotmail.com", "Somewhere under the rainbow", "02456789120", "password"));
        save(new User("Herwig", "Frans", "herwigfrans@hotmail.com", "Somewhere in Leuven", "0245785123", "password"));
        save(new User("Jan", "Broeckx", "janbroeckx@hotmail.com", "Somewhere in Antwerp", "02457568764", "password"));
        save(new User("Harold", "van Doorslaer", "haroldvandoorslaer@hotmail.com", "Somewhere in Brussels", "02456789125", "password"));
        userDatabase.get("02456789120").setRole(Role.ADMIN);
    }

    public ConcurrentHashMap<String, User> getUserDatabase() {
        return userDatabase;
    }
}
