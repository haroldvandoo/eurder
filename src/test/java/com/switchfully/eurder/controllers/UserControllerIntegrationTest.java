package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.repositories.UserRepository;
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
        UserDto userDto = new UserDto("Tom", "Jansens", "tomjansens@hotmail.com", "Somewhere under the rainbow", "02456789120");
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailAddress(), userDto.getAddress(), userDto.getPhoneNumber());

        //when
        userController.createUser(userDto);

        //then
        Assertions.assertTrue(userService.getUserRepository().getUserDatabase().get("02456789120").equals(user));
    }



}