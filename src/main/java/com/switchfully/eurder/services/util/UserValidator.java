package com.switchfully.eurder.services.util;

import com.switchfully.eurder.domain.dto.userdto.CreateUserDto;
import com.switchfully.eurder.domain.dto.userdto.UserDto;
import com.switchfully.eurder.exceptions.all.*;
import com.switchfully.eurder.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void isValidEmail(String emailAddress) {
        if (!emailAddress.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new InvalidEmailAddressException();
        }
    }

    public void isEmailUnique(String emailAdress) {
        if (userRepository.findUserByEmailAddress(emailAdress) != null)
            throw new NotUniqueEmailException();
    }

    public void checkRequiredFields(CreateUserDto createUserDto) {
        if (createUserDto.getEmailAddress() == null || createUserDto.getEmailAddress().equals("")) {
            throw new EmptyEmailException();
        }
        if (createUserDto.getFirstName() == null || createUserDto.getFirstName().equals("")) {
            throw new EmptyFirstNameException();
        }
        if (createUserDto.getLastName() == null || createUserDto.getLastName().equals("")) {
            throw new EmptyLastNameException();
        }
        if (createUserDto.getPhoneNumber() == null || createUserDto.getPhoneNumber().equals("")) {
            throw new EmptyPhoneException();
        }
        if (createUserDto.getAddress() == null || createUserDto.getAddress().equals("")) {
            throw new EmptyAddressException();
        }
    }
}
