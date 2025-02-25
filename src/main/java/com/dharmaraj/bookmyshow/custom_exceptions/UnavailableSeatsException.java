package com.dharmaraj.bookmyshow.custom_exceptions;

public class UnavailableSeatsException extends Exception {
    
    public UnavailableSeatsException(String unavilableSeats) {

        super("Seats are not available " + unavilableSeats + ".");
    }
}
