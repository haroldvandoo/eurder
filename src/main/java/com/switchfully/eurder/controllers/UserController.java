package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.userdto.UserDtoPrivate;
import com.switchfully.eurder.domain.dto.userdto.UserDtoPublic;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    UserService userService;
    UserMapper userMapper;

    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = new UserMapper();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoPublic createUser(@RequestBody UserDtoPrivate userDtoPrivate) {
        log.info("created the following user: " + userDtoPrivate);
        return userService.addUser(userDtoPrivate);
    }
}
