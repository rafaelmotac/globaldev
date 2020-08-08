package org.globaldev.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidPasswordException extends AuthenticationException {
    public InvalidPasswordException(String e) {
        super(e);
    }

    public InvalidPasswordException(){
        super("Invalid Password");
    }
}