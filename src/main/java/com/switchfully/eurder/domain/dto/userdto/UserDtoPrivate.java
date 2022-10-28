package com.switchfully.eurder.domain.dto.userdto;

import com.switchfully.eurder.security.Role;

public class UserDtoPrivate {

    private Role role;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;
    private String password;

    public UserDtoPrivate(Role role, String firstName, String lastName, String emailAddress, String address, String phoneNumber, String password) {
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDtoPrivate userDtoPrivate)) return false;

        if (role != userDtoPrivate.role) return false;
        if (getFirstName() != null ? !getFirstName().equals(userDtoPrivate.getFirstName()) : userDtoPrivate.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(userDtoPrivate.getLastName()) : userDtoPrivate.getLastName() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(userDtoPrivate.getEmailAddress()) : userDtoPrivate.getEmailAddress() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(userDtoPrivate.getAddress()) : userDtoPrivate.getAddress() != null)
            return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(userDtoPrivate.getPhoneNumber()) : userDtoPrivate.getPhoneNumber() == null;
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
