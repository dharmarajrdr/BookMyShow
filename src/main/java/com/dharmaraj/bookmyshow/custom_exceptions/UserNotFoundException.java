package com.dharmaraj.bookmyshow.custom_exceptions;

public class UserNotFoundException extends Exception {
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
