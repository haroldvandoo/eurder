package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.domain.User;

public class UserMapper {

    public UserMapper() {
    }

    public User userDtoPrivateToUser(UserDtoPrivate userDtoPrivate) {
        return new User(userDtoPrivate.getFirstName(), userDtoPrivate.getLastName(), userDtoPrivate.getEmailAddress(), userDtoPrivate.getAddress(), userDtoPrivate.getPhoneNumber(),userDtoPrivate.getPassword());
    }

    public UserDtoPrivate userToUserDtoPrivate(User user) {
        return new UserDtoPrivate(user.getRole(),user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber(), user.getPassword());
    }

    public UserDtoPublic userToUserDtoPublic(User user) {
        return new UserDtoPublic(user.getRole(),user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getAddress(), user.getPhoneNumber());
    }


}
