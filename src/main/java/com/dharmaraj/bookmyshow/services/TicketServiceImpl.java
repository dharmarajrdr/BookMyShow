package com.dharmaraj.bookmyshow.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dharmaraj.bookmyshow.custom_exceptions.InvalidShowSeatIdException;
import com.dharmaraj.bookmyshow.custom_exceptions.UnavailableSeatsException;
import com.dharmaraj.bookmyshow.custom_exceptions.UserNotFoundException;
import com.dharmaraj.bookmyshow.models.Seat;
import com.dharmaraj.bookmyshow.models.SeatStatus;
import com.dharmaraj.bookmyshow.models.Show;
import com.dharmaraj.bookmyshow.models.ShowSeat;
import com.dharmaraj.bookmyshow.models.Ticket;
import com.dharmaraj.bookmyshow.models.TicketStatus;
import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.repositories.ShowSeatRepository;
import com.dharmaraj.bookmyshow.repositories.TicketRepository;
import com.dharmaraj.bookmyshow.repositories.UserRepository;

@Service
public class TicketServiceImpl implements TicketService {

    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(UserRepository userRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public List<ShowSeat> getUnavailableSeats(List<Integer> showSeatIds) throws InvalidShowSeatIdException {

        List<ShowSeat> unavailableSeats = new ArrayList<>();
        for(Integer showSeatId: showSeatIds) {
            ShowSeat showSeat = this.showSeatRepository.findById(showSeatId).orElseThrow(() -> new InvalidShowSeatIdException(showSeatId));
            if(!showSeat.isAvailable()) {
                unavailableSeats.add(showSeat);
            }
        }
        return unavailableSeats;
    }

    @Transactional
    public List<Seat> bookSeats(List<Integer> showSeatIds) throws InvalidShowSeatIdException {
        
        List<Seat> seats = new ArrayList<>();
        for(Integer showSeatId: showSeatIds) {
            ShowSeat showSeat = this.showSeatRepository.findById(showSeatId).orElseThrow(() -> new InvalidShowSeatIdException(showSeatId));
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            this.showSeatRepository.save(showSeat);
            seats.add(showSeat.getSeat());
        }
        return seats;
    }

    @Override
    @Transactional
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " does not exist."));

        List<ShowSeat> unavailableSeats = getUnavailableSeats(showSeatIds);
        if(!unavailableSeats.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for(ShowSeat showSeat: unavailableSeats) {
                sb.append(", " + showSeat.getId());
            }
            throw new UnavailableSeatsException(sb.toString());
        }

        List<Seat> seats = bookSeats(showSeatIds);

        Show show = this.showSeatRepository.findById(showSeatIds.get(0)).orElseThrow(() -> new InvalidShowSeatIdException(showSeatIds.get(0))).getShow();

        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setTimeOfBooking(new Date());
        ticket.setUser(user);
        ticket.setSeats(seats);
        ticket.setTicketStatus(TicketStatus.UNPAID);
        this.ticketRepository.save(ticket);
        return ticket;
    }
    
}
