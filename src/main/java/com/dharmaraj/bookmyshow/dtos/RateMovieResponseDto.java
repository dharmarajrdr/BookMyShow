package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Rating;

import lombok.Data;

@Data
public class RateMovieResponseDto {
    
    private ResponseStatus responseStatus;
    private Rating rating;
}
