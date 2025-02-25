package com.dharmaraj.bookmyshow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dharmaraj.bookmyshow.dtos.BookTicketRequestDTO;
import com.dharmaraj.bookmyshow.dtos.BookTicketResponseDTO;
import com.dharmaraj.bookmyshow.dtos.ResponseStatus;
import com.dharmaraj.bookmyshow.models.Ticket;
import com.dharmaraj.bookmyshow.services.TicketService;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO) {
        BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();
        try {
            List<Integer> showSeatIds = requestDTO.getShowSeatIds();
            int userId = requestDTO.getUserId();
            Ticket ticket = this.ticketService.bookTicket(showSeatIds, userId);
            bookTicketResponseDTO.setTicket(ticket);
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookTicketResponseDTO;
    }
}
