package com.example.flightreservation.repository;

import com.example.flightreservation.entity.AirCraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCraftRepo extends JpaRepository<AirCraft,Integer> {
}
