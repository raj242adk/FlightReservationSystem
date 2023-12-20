package com.example.flightreservation.controller;

import com.example.flightreservation.dto.response.BookingResponse;
import com.example.flightreservation.entity.Booking;
import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.entity.Passenger;
import com.example.flightreservation.repository.FlightRepo;
import com.example.flightreservation.repository.PassengerRepository;
import com.example.flightreservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping("/booking/save")
    public String Save(){
        return "Ok";
    }
    @PostMapping("/booking/save")
    public ResponseEntity<Object> createBooking(@RequestBody Booking request) {
        try {
            Booking booking = bookingService.createBooking(request);
            return ResponseEntity.ok().body(booking);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Entity not found");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
