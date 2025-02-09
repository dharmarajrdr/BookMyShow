package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.custom_exceptions.MovieNotFoundException;
import com.dharmaraj.bookmyshow.custom_exceptions.UserNotFoundException;
import com.dharmaraj.bookmyshow.models.Rating;

public interface RatingsService {

    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException;

    public double getAverageRating(int movieId) throws MovieNotFoundException;
}
