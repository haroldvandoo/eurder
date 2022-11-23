package com.switchfully.eurder.security;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.exceptions.all.AccessDeniedException;
import com.switchfully.eurder.exceptions.all.UnkownUserException;
import com.switchfully.eurder.exceptions.all.WrongPasswordException;
import com.switchfully.eurder.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {

    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    private UserRepository userRepository;


    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAuthorization(String authorization, Feature feature) {
        UsernamePassword usernamePassword = getUsernamePassword(authorization);
        Long userId = Long.parseLong(usernamePassword.getUsername());
        User user = userRepository.findById(userId).orElseThrow(() -> new UnkownUserException());
        if (!user.doesPasswordMatch(usernamePassword.getPassword())) {
            logger.error("Password does not match for user " + usernamePassword.getUsername());
            throw new WrongPasswordException();
        }

        if(!user.canHaveAccessTo(feature)){
            logger.error("User "+usernamePassword.getUsername()+" does not have access to "+feature);
            throw new AccessDeniedException();
        }
    }

    public UsernamePassword getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UsernamePassword(username, password);
    }
}


