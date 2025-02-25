package com.dharmaraj.bookmyshow.custom_exceptions;


public class InvalidShowSeatIdException extends Exception {
    
    public InvalidShowSeatIdException(Integer showSeatId) {
        super("Show Seat with id " + showSeatId + " does not exist.");
    }
}
