package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.dto.userdto.CreateUserDto;
import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.exceptions.all.NonExistingUserException;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.services.util.UserValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;
    UserValidator userValidator;
    UserMapper userMapper;

    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.userMapper = new UserMapper();
    }

    public UserDto addUser(CreateUserDto createUserDto) {
        User newUser = userMapper.createUserDtoToUser(createUserDto);
        userValidator.isValidEmail(createUserDto.getEmailAddress());
        userValidator.isEmailUnique(createUserDto.getEmailAddress());
        userValidator.checkRequiredFields(createUserDto);
        userRepository.save(newUser);
        return userMapper.userToUserDto(newUser);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public List<CreateUserDto> getAllCustomers() {
        List<User> userList = userRepository.findAll();
        List<User> memberList = userList.stream().filter(user -> user.getRole().equals(Role.CUSTOMER)).collect(Collectors.toList());
        return userMapper.userToUserDtoPublicList(memberList);
    }

    public CreateUserDto getUserById(Long id) {
        return userMapper.userToCreateUserDto(userRepository.findById(id).orElseThrow(NonExistingUserException::new));
    }
}
