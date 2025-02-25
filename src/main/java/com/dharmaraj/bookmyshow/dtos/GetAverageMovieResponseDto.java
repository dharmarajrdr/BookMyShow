package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetAverageMovieResponseDto extends BaseResponse {
    
    private double averageRating;

}