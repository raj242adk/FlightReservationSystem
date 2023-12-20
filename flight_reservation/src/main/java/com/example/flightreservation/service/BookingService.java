package com.example.flightreservation.service;

import com.example.flightreservation.entity.Booking;
import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.entity.Passenger;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    public Booking createBooking(Booking request);
}
