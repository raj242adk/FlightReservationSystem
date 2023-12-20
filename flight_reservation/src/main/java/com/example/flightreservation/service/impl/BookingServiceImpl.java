package com.example.flightreservation.service.impl;

import com.example.flightreservation.entity.Booking;
import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.entity.Passenger;
import com.example.flightreservation.repository.BookingRepo;
import com.example.flightreservation.repository.FlightRepo;
import com.example.flightreservation.repository.PassengerRepository;
import com.example.flightreservation.service.BookingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    FlightRepo flightRepo;
    @Autowired
    PassengerRepository passengerRepository;


    @Override
    public Booking createBooking(Booking request) {
        Integer flightId = request.getFlight().getId();
        Integer passengerId = request.getPassenger().getId();
        Integer seatsToBook = request.getSeats();

        if (seatsToBook == null) {
            throw new IllegalArgumentException("Number of seats to book cannot be null");
        }

        Flight flight = flightRepo.findById(flightId)
                .orElseThrow(() -> new NoSuchElementException("Flight not found"));

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new NoSuchElementException("Passenger not found"));

        // Additional logic, if needed

        // Check if the passenger has an existing booking
        if (bookingRepo.existsByPassengerId(passenger.getId())) {
            throw new IllegalArgumentException("Passenger already has a booking");
        }

        // Check if there are enough available seats
        int availableSeats = flight.getAvailableSeats();
        if (seatsToBook > availableSeats) {
            throw new IllegalArgumentException("Not enough available seats for booking");
        }

        // Update the available seats for the flight
        flight.setAvailableSeats(availableSeats - seatsToBook);

        // Create the booking
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setSeats(seatsToBook);
        booking.setEmail(request.getEmail());
        // set other properties if needed

        // Save the updated flight and create the booking
        flightRepo.save(flight);
        return bookingRepo.save(booking);
    }


}
