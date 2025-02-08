package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private SeatStatus seatStatus;
}

/**
 * ShowSeat : Show ( M : 1 )
 * 1 : 1        => One showSeat belongs to that particular show
 * M : 1        => One show can have many showSeats
 */

/**
 * ShowSeat : Seat ( M : 1 )
 * 1 : 1        => One show seat have one seat
 * M : 1        => But, that seat can be in many other show
 */