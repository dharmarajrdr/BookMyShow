package com.dharmaraj.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.bookmyshow.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

}