package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.dto.userdto.UserDtoPrivate;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;




    @Test
    void addNewCustomerAsUnregisteredUser_HappyPath() {
        //given
        UserDtoPrivate userDtoPrivate = new UserDtoPrivate(Role.CUSTOMER, "Tom", "Jansens", "patron@hotmail.com", "Somewhere under the rainbow", "02456789129", "password");
        User user = new User(userDtoPrivate.getFirstName(), userDtoPrivate.getLastName(), userDtoPrivate.getEmailAddress(), userDtoPrivate.getAddress(), userDtoPrivate.getPhoneNumber(), userDtoPrivate.getPassword());
        //when
        userController.createUser(userDtoPrivate);
        //then
        Assertions.assertTrue(userService.getUserRepository().getUserDatabase().get("02456789129").equals(user));
    }





}