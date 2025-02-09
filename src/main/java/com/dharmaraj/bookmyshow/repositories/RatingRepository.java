package com.dharmaraj.bookmyshow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.bookmyshow.models.Movie;
import com.dharmaraj.bookmyshow.models.Rating;
import com.dharmaraj.bookmyshow.models.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    public Optional<Rating> findByUserAndMovie(User user, Movie movie);

    public Optional<List<Rating>> findByMovie(Movie movie);
}