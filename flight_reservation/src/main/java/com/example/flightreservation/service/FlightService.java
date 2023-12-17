package com.example.flightreservation.service;

import com.example.flightreservation.entity.Flight;

import java.util.List;

public interface FlightService {

     public List<Flight> findAll();

     public Flight updateFlight(Flight updateflight);

     Flight saveFlight(Flight flight);
}
