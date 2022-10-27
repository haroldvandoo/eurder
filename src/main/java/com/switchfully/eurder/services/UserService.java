package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = new UserMapper();
    }

    //ToDo are checks required?
    public UserDto addUser(UserDto userDto) {
        User newUser = userMapper.userDtoToUser(userDto);
        userRepository.save(newUser);
        return userDto;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
