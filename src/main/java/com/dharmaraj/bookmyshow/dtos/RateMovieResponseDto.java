package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.Rating;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RateMovieResponseDto extends BaseResponse {
    
    private Rating rating;
}
