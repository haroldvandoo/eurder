package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.security.Role;

public class UserDto {

    private Long id;


    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    private Role role;
    //private String password;


    public UserDto(Long id, String firstName, String lastName, String emailAddress, String address, String phoneNumber, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Long getId() {
        return id;
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

    public Role getRole() {
        return role;
    }

    /**
    public String getPassword() {
        return password;
    }
     */


}
