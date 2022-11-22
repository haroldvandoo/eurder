package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAddress (String emailAddress);
}
