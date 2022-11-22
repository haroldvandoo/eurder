package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserMapper() {
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailAddress(), userDto.getAddress(), userDto.getPhoneNumber()
                //,userDtoPrivate.getPassword()
        );
    }

    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(),user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber(), user.getRole()
                //, user.getPassword()
        );
    }

    public User createUserDtoToUser(CreateUserDto createUserDto) {
        return new User(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getEmailAddress(), createUserDto.getAddress(), createUserDto.getPhoneNumber());
    }

    public CreateUserDto userToCreateUserDto(User user) {
        return new CreateUserDto(user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber(), user.getRole());
    }

    public List<CreateUserDto> userToUserDtoPublicList (List<User> userList) {
        return userList.stream().map(user -> userToCreateUserDto(user)).collect(Collectors.toList());
    }


}
