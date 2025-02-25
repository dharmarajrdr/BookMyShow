package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class GetAverageMovieResponseDto extends BaseResponse {
    
    
    private double averageRating;

}