package com.flightservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservices.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
