package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel {

    private long ticketNumber;
    private TicketStatus ticketStatus;
    private User user;
    private double amount;
    private List<ShowSeat> seats;
    private List<Payment> payments;
}
