package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    private long ticketNumber;

    private TicketStatus ticketStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    private double amount;

    @OneToMany  // Didn't used mappedBy. Because, Seat class doesn't persist Seat. So, we can't map seat
    private List<Seat> seats;

    @OneToMany
    private List<Payment> payments;

    private Date timeOfBooking;
}

/**
 * Ticket : User ( M : 1 )
 * 1 : 1        =>  One ticket belongs to one user
 * M : 1        =>  One user can have many ticket
 */

/**
 * Ticket : ShowSeat ( M : M )
 * 1 : M        =>  One ticket can have many seats
 * M : 1        =>  One show seat can be booked by many ticket (in case of cancellation)
 */

/**
 * Ticket : Payment ( 1 : M )
 * 1 : M        =>  One ticket can be booked by multiple payments (wallet + UPI)
 * 1 : 1        =>  One payment can belongs to that particular ticket.
 */