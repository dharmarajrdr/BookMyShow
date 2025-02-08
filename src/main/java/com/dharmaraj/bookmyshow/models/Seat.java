package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {

    private char row;
    private int number;
    private SeatType seatType;
}
