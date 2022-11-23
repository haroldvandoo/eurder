package com.switchfully.eurder.domain;

import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.Role;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "eurder_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String emailAddress;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role role;

    @Column(name = "password")
    private String password;

    //todo check security

    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String address, String phoneNumber, String password) {
        this.role = Role.CUSTOMER;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
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

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(id, user.id);
    }

/**
   public boolean doesPasswordMatch(String password) {
        return this.password.equals(password);
    }
 */

    public boolean canHaveAccessTo(Feature feature) {
        return role.containsFeature(feature);
    }
}
