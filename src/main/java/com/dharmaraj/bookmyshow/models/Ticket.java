package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    private long ticketNumber;
    private TicketStatus ticketStatus;
    private User user;
    private double amount;
    private List<ShowSeat> seats;
    private List<Payment> payments;
}
