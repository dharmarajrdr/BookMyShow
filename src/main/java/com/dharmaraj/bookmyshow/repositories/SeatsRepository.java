package com.dharmaraj.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.bookmyshow.models.Seat;

@Repository
public interface SeatsRepository extends JpaRepository<Seat, Integer> {

}