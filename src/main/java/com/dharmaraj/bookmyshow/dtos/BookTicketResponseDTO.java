package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Ticket;

import lombok.Data;


@Data
public class BookTicketResponseDTO {
    
    private Ticket ticket;

    private ResponseStatus status;
}
