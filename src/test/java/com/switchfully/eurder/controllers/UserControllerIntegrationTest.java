package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.repositories.UserRepository;
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

    @Test
    void addNewMember_HappyPath() {
        //given
        UserDto userDto = new UserDto("Tom", "Jansens", "tomjansens@hotmail.com", "Somewhere under the rainbow", "02456789120");

        //when
        UserDto returnedUserDto = userController.createUser(userDto);

        //then
        Assertions.assertTrue(userRepository.getUserDatabase().containsKey("02456789120"));

    }


}