package com.example.flightreservationsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.attribute.standard.DateTimeAtCreation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aircrafts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer air_ID;
    private String air_number;
    private Integer capacity;
    private String mfd_by;
    private String mfd_on;
}
