package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.dto.userdto.UserDtoPrivate;
import com.switchfully.eurder.domain.dto.userdto.UserDtoPublic;
import com.switchfully.eurder.domain.dto.userdto.UserMapper;
import com.switchfully.eurder.exceptions.all.InvalidEmailAddressException;
import com.switchfully.eurder.exceptions.all.NotUniqueEmailException;
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
    public UserDtoPublic addUser(UserDtoPrivate userDtoPrivate) {
        User newUser = userMapper.userDtoPrivateToUser(userDtoPrivate);
        isValidEmail(userDtoPrivate.getEmailAddress());
        isEmailUnique(userDtoPrivate.getEmailAddress());
        checkRequiredFields(userDtoPrivate);
        userRepository.save(newUser);
        return userMapper.userToUserDtoPublic(newUser);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void isValidEmail(String emailAddress) {
        if (!emailAddress.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new InvalidEmailAddressException();
        }
    }

    public void isEmailUnique(String emailAdress) {
        if (userRepository.getUserDatabase().values().stream().anyMatch(member -> emailAdress.equals(member.getEmailAddress())))
            throw new NotUniqueEmailException();
    }

    public void checkRequiredFields(UserDtoPrivate userDtoPrivate) {
        if (userDtoPrivate.getEmailAddress() == null || userDtoPrivate.getEmailAddress().equals("")) {
            throw new IllegalArgumentException("Provide an Email address please!");
        }
        if (userDtoPrivate.getFirstName() == null || userDtoPrivate.getFirstName().equals("")) {
            throw new IllegalArgumentException("Provide a first name please!");
        }
        if (userDtoPrivate.getLastName() == null || userDtoPrivate.getLastName().equals("")) {
            throw new IllegalArgumentException("Provide a lastname please!");
        }
        if (userDtoPrivate.getPhoneNumber() == null || userDtoPrivate.getPhoneNumber().equals("")) {
            throw new IllegalArgumentException("Provide a phone number please!");
        }
        if (userDtoPrivate.getAddress() == null || userDtoPrivate.getAddress().equals("")) {
            throw new IllegalArgumentException("Provide an address please!");
        }
    }
}
