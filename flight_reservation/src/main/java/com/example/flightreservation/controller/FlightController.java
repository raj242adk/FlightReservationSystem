package com.example.flightreservation.controller;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("/flight/add")
    public String flight() {
        return "FlightDetails";
    }

    @GetMapping("/flight/findAll")
    public String flightFindAll(Model model) {
        List<Flight> flight = flightService.findAll();
        model.addAttribute("allFlight", flight);
        return "showAllFlight";

    }


    @PostMapping("/flight/add")
    public String flightadd(@ModelAttribute Flight flight) {
        flightService.saveFlight(flight);
        return "redirect:/admin";

    }

}
