package com.dharmaraj.bookmyshow.custom_exceptions;

public class ScheduleNotFoundException extends Exception {

    public ScheduleNotFoundException(String taskName) {

        super("Schedule with name '" + taskName + "' does not exist.");
    }
}
