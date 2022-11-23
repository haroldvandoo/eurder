package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.security.Role;

public class CreateUserDto {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    private String password;

    public CreateUserDto(String firstName, String lastName, String emailAddress, String address, String phoneNumber,  String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

}
