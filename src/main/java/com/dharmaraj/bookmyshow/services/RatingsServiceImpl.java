package com.dharmaraj.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharmaraj.bookmyshow.custom_exceptions.MovieNotFoundException;
import com.dharmaraj.bookmyshow.custom_exceptions.UserNotFoundException;
import com.dharmaraj.bookmyshow.models.Movie;
import com.dharmaraj.bookmyshow.models.Rating;
import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.repositories.MovieRepository;
import com.dharmaraj.bookmyshow.repositories.RatingRepository;
import com.dharmaraj.bookmyshow.repositories.UserRepository;

@Service
public class RatingsServiceImpl implements RatingsService {

    private RatingRepository ratingRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;

    @Autowired
    public RatingsServiceImpl(RatingRepository ratingRepository, UserRepository userRepository,
            MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Rating rateMovie(int userId, int movieId, int rate) throws UserNotFoundException, MovieNotFoundException {

        Rating rating;

        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        Optional<Movie> optionalMovie = this.movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException("Movie not found");
        }

        User user = optionalUser.get();
        Movie movie = optionalMovie.get();

        Optional<Rating> optionalRating = this.ratingRepository.findByUserAndMovie(user, movie);
        if (optionalRating.isPresent()) {
            rating = optionalRating.get();
            rating.setRating(rate);
        } else {
            rating = new Rating();
            rating.setUser(user);
            rating.setMovie(movie);
            rating.setRating(rate);
        }
        
        this.ratingRepository.save(rating);
        return rating;
    }

    @Override
    public double getAverageRating(int movieId) throws MovieNotFoundException {

        Optional<Movie> optionalMovie = this.movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException("Movie not found");
        }

        List<Rating> ratings = ratingRepository.findByMovie(optionalMovie.get())
                .orElseThrow(() -> new MovieNotFoundException("No ratings found for this movie"));
        double rate = 0;
        for (Rating rating : ratings) {
            rate += rating.getRating();
        }
        return rate / ratings.size();
    }

}
