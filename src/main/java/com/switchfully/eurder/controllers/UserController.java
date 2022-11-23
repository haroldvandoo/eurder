package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.domain.dto.userdto.CreateUserDto;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.SecurityService;
import com.switchfully.eurder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    UserService userService;
    UserMapper userMapper;
    SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.userMapper = new UserMapper();
       this.securityService = securityService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        log.info("created the following user: " + createUserDto);
        return userService.addUser(createUserDto);
    }


    //todo fix security service!!

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllCustomers(@RequestHeader String authorization){
        log.info("fetching all customers.");
        securityService.validateAuthorization(authorization, Feature.GET_ALLCUSTOMERS);
        return userService.getAllCustomers();
    }

    @GetMapping (path= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getCustomerById(@RequestHeader String authorization, @PathVariable Long id) {
        log.info("retrieving user with id:" + id);
        securityService.validateAuthorization(authorization, Feature.GET_SINGLECUSTOMER);
        return userService.getUserById(id);
    }


}
