package com.dharmaraj.bookmyshow.custom_exceptions;

public class MovieNotFoundException extends Exception {
    
    public MovieNotFoundException(String message) {
        super(message);
    }
}
