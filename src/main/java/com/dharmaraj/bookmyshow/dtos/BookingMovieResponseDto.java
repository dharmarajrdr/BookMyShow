package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingMovieResponseDto extends BaseResponse {

    private Ticket ticket;
}
