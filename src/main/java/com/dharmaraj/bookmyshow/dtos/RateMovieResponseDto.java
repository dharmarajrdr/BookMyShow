package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Rating;

import lombok.Data;

@Data
public class RateMovieResponseDto extends BaseResponse {
    
    private Rating rating;
}
