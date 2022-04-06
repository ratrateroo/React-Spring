package com.flightservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservices.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
