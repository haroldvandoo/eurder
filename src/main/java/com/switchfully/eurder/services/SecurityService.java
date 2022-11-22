package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.exceptions.all.AccessDeniedException;
import com.switchfully.eurder.exceptions.all.UnkownUserException;
import com.switchfully.eurder.exceptions.all.WrongPasswordException;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.UsernamePassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;
/**
@Service
public class SecurityService {

    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    private UserRepositoryOld userRepositoryOld;

    public SecurityService(UserRepositoryOld userRepositoryOld) {
        this.userRepositoryOld = userRepositoryOld;
    }

    public void validateAuthorization(String authorization, Feature feature) {
        UsernamePassword usernamePassword = getUsernamePassword(authorization);
        User user = userRepositoryOld.getUserDatabase().get(usernamePassword.getUsername());
        if (user == null) {
            logger.error("Unkown user" + usernamePassword.getPassword());
            throw new UnkownUserException();
        }
        /**
        if (!user.doesPasswordMatch(usernamePassword.getPassword())) {
            logger.error("Password does not match for user " + usernamePassword.getUsername());
            throw new WrongPasswordException();
        }

        if(!user.canHaveAccessTo(feature)) {
            logger.error("User " + usernamePassword.getUsername() + " does not have access to " + feature);
            throw new AccessDeniedException();
        }
    }

    private UsernamePassword getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UsernamePassword(username, password);
    }
}
 */
