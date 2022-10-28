package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.dto.userdto.UserDtoPrivate;
import com.switchfully.eurder.exceptions.all.InvalidEmailAddressException;
import com.switchfully.eurder.exceptions.all.NotUniqueEmailException;
import com.switchfully.eurder.security.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void whenCreatingAMemberWithoutProvidingAValidEmail_ThrowAnError() {
        Assertions.assertThrows(InvalidEmailAddressException.class, () -> userService.addUser(new UserDtoPrivate(Role.CUSTOMER,"Jan", "Janssens", "dfzef.com", "Somewhere under the rainbow", "02154678", "password")));
    }

    @Test
    public void whenCreatingAMemberWithAnAlreadyRegisteredEmail_ThrowAnError() {
        Assertions.assertThrows(NotUniqueEmailException.class, () -> userService.addUser(new UserDtoPrivate(Role.CUSTOMER,"Jan", "Janssens", "haroldvandoorslaer@hotmail.com", "Somewhere under the rainbow", "02154678", "password")));
    }

    @Test
    public void whenCreatingAMemberWithoutProvidingAllInformation_ThrowAnError() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.addUser(new UserDtoPrivate(Role.CUSTOMER,"", "Janssens", "aight@hotmail.com", "Somewhere under the rainbow", "02154678", "password")));
    }


}