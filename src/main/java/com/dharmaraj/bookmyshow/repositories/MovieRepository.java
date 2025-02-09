package com.dharmaraj.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.bookmyshow.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    
    @Override
    Optional<Movie> findById(Integer integer);
}
