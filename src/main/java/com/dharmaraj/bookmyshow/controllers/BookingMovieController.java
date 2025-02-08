package com.dharmaraj.bookmyshow.controllers;

import com.dharmaraj.bookmyshow.dtos.BookingMovieRequestDto;
import com.dharmaraj.bookmyshow.dtos.BookingMovieResponseDto;
import com.dharmaraj.bookmyshow.dtos.ResponseStatus;
import com.dharmaraj.bookmyshow.models.Ticket;
import com.dharmaraj.bookmyshow.services.BookMovieService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingMovieController {

    private BookMovieService bookMovieService;

    public BookingMovieController(BookMovieService bookMovieService) {
        this.bookMovieService = bookMovieService;
    }

    public BookingMovieResponseDto bookMovie(BookingMovieRequestDto bookingMovieRequestDto) {

        BookingMovieResponseDto bookingMovieResponseDto = new BookingMovieResponseDto();
        try {
            Long userId = bookingMovieRequestDto.getUserId();
            List<Long> showSeatIds = bookingMovieRequestDto.getShowSeatIds();
            Long showId = bookingMovieRequestDto.getShowId();
            Ticket ticket = this.bookMovieService.bookMovie(userId, showSeatIds, showId);
            bookingMovieResponseDto.setTicket(ticket);
            bookingMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            bookingMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            bookingMovieResponseDto.setMessage(e.getMessage());
        }
        return bookingMovieResponseDto;
    }
}
