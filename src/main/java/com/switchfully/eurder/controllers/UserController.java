package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("created the following user: " + userDto);
        return userService.addUser(userDto);
    }
}
