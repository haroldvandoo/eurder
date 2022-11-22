package com.switchfully.eurder.exceptions.all;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EmptyAddressException extends IllegalArgumentException{
}
