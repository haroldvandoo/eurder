package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserMapper() {
    }


    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(),user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber(), user.getRole());
    }

    public User createUserDtoToUser(CreateUserDto createUserDto) {
        return new User(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getEmailAddress(), createUserDto.getAddress(), createUserDto.getPhoneNumber(), createUserDto.getPassword());
    }

    public CreateUserDto userToCreateUserDto(User user) {
        return new CreateUserDto(user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber(), user.getPassword());
    }

    public List<UserDto> userToUserDtoList(List<User> userList) {
        return userList.stream().map(this::userToUserDto).collect(Collectors.toList());
    }


}
