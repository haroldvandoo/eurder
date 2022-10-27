package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.domain.Role;

public class UserDto {

    private Role role;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    public UserDto(String firstName, String lastName, String emailAddress, String address, String phoneNumber) {
        this.role = Role.CUSTOMER;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;

        if (role != userDto.role) return false;
        if (getFirstName() != null ? !getFirstName().equals(userDto.getFirstName()) : userDto.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(userDto.getLastName()) : userDto.getLastName() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(userDto.getEmailAddress()) : userDto.getEmailAddress() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(userDto.getAddress()) : userDto.getAddress() != null)
            return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(userDto.getPhoneNumber()) : userDto.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = role != null ? role.hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }
}
