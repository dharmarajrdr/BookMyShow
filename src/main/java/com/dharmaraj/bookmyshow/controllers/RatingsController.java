package com.dharmaraj.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dharmaraj.bookmyshow.custom_exceptions.MovieNotFoundException;
import com.dharmaraj.bookmyshow.custom_exceptions.UserNotFoundException;
import com.dharmaraj.bookmyshow.dtos.GetAverageMovieRequestDto;
import com.dharmaraj.bookmyshow.dtos.GetAverageMovieResponseDto;
import com.dharmaraj.bookmyshow.dtos.RateMovieRequestDto;
import com.dharmaraj.bookmyshow.dtos.RateMovieResponseDto;
import com.dharmaraj.bookmyshow.dtos.ResponseStatus;
import com.dharmaraj.bookmyshow.models.Rating;
import com.dharmaraj.bookmyshow.services.RatingsService;

@Controller
public class RatingsController {
    
    @Autowired
    private RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    public RateMovieResponseDto rateMovie(RateMovieRequestDto requestDto) {
        RateMovieResponseDto rateMovieResponseDto = new RateMovieResponseDto();
        try {
            int userId = requestDto.getUserId();
            int movieId = requestDto.getMovieId();
            int ratingId = requestDto.getRating();
            Rating rating = this.ratingsService.rateMovie(userId, movieId, ratingId);
            rateMovieResponseDto.setRating(rating);
            rateMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException | MovieNotFoundException e) {
            rateMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return rateMovieResponseDto;
    }

    public GetAverageMovieResponseDto getAverageMovieRating(GetAverageMovieRequestDto requestDto) {
        GetAverageMovieResponseDto getAverageMovieResponseDto = new GetAverageMovieResponseDto();
        try {
            int movieId = requestDto.getMovieId();
            double averageRating = this.ratingsService.getAverageRating(movieId);
            getAverageMovieResponseDto.setAverageRating(averageRating);
            getAverageMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (MovieNotFoundException e) {
            getAverageMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return getAverageMovieResponseDto;
    }

}
