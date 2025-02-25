package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    public boolean isAvailable() {
        return this.seatStatus.equals(SeatStatus.AVAILABLE);
    }
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