package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private double price;
}

/**
 * ShowSeatType : Show ( M : 1 )
 * 1 : 1        => One showSeatType belongs to that particular show
 * M : 1        => One show can multiple showSeatType
 */

/**
 * ShowSeatType : SeatType ( M : 1 )
 * 1 : 1        => One showSeatType belongs to that particular seat type
 * M : 1        => One seat type can be in many showSeatType
 */