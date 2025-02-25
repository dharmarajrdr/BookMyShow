package com.dharmaraj.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.bookmyshow.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
