package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private char row;
    private int number;
    private SeatType seatType;
}
