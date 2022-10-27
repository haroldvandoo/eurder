package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.domain.User;

public class UserMapper {

    public UserMapper() {
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailAddress(), userDto.getAddress(), userDto.getPhoneNumber());
    }

    public UserDto userToUserDto (User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber());
    }

}
