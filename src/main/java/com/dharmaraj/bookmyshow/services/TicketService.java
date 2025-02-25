package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception;
}
