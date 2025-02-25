package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Ticket;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class BookTicketResponseDTO extends BaseResponse {
    
    private Ticket ticket;
}
