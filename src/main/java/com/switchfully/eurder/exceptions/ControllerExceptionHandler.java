package com.switchfully.eurder.exceptions;

import com.switchfully.eurder.exceptions.all.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotUniqueEmailException.class)
    protected void NotUniqueEmailException(NotUniqueEmailException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "This email has already been used.");
    }

    @ExceptionHandler(InvalidEmailAddressException.class)
    protected void InvalidEmailAddressException(InvalidEmailAddressException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "This email is not valid.");
    }

    @ExceptionHandler(UnkownUserException.class)
    protected void UnkownUserException(UnkownUserException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unknown user.");
    }

    @ExceptionHandler(WrongPasswordException.class)
    protected void WrongPasswordException(WrongPasswordException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Incorrect password, please try again");
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected void AccessDeniedException(AccessDeniedException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "You do not have the right for this action");
    }

    @ExceptionHandler(IdAlreadyUsedException.class)
    protected void IdAlreadyUsedException(IdAlreadyUsedException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "This ID is already used");
    }

    @ExceptionHandler(NonExistingUserException.class)
    protected void NonExistingUserException(NonExistingUserException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "This ID is not registered");
    }

    @ExceptionHandler(EmptyEmailException.class)
    protected void EmptyEmailException(EmptyEmailException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "Please provide an email.");
    }

    @ExceptionHandler(EmptyFirstNameException.class)
    protected void EmptyFirstNameException(EmptyFirstNameException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "Please provide a first name.");
    }

    @ExceptionHandler(EmptyLastNameException.class)
    protected void EmptyLastNameException(EmptyLastNameException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "Please provide a last name.");
    }

    @ExceptionHandler(EmptyPhoneException.class)
    protected void EmptyPhoneException(EmptyPhoneException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(),     "Provide a phone number please!");
    }

    @ExceptionHandler(EmptyAddressException.class)
    protected void EmptyAddressException(EmptyAddressException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(),     "Provide an address please!");
    }

}
