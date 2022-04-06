package com.flightservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservices.entities.Flight;

public interface ReservationRepository extends JpaRepository<Flight, Integer> {

}
