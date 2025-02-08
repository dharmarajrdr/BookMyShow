package com.dharmaraj.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingMovieRequestDto {

    private Long userId;

    private List<Long> showSeatIds;

    private Long showId;
}
