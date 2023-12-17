package com.example.flightreservation.service.impl;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.repository.FlightRepo;
import com.example.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepo flightRepo;

    @Override
    public List<Flight> findAll() {
       return flightRepo.findAll();
    }

    @Override
    public Flight updateFlight(Flight updateflight) {
        Optional<Flight> flight=flightRepo.findById(updateflight.getId());
        if(flight.isPresent()){
            // Get the existing flight from the optional
            Flight existingFlight=flight.get();
            existingFlight.setFlightNumber(updateflight.getFlightNumber());
            existingFlight.setAirline(updateflight.getAirline());
            existingFlight.setDeparture_gate(updateflight.getDeparture_gate());
            existingFlight.setArrival_gate(updateflight.getArrival_gate());
            existingFlight.setDepartureDateTime(updateflight.getDepartureDateTime());
            existingFlight.setArrivalDateTime(updateflight.getArrivalDateTime());
            existingFlight.setAvailableSeats(updateflight.getAvailableSeats());
            return flightRepo.save(existingFlight);

        }else {
            return null;
        }
    }

    @Override
    public Flight saveFlight(Flight flight) {
       return flightRepo.save(flight);
    }
}
