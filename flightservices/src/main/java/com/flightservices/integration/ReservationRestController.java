package com.flightservices.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightservices.dto.CreateReservationRequest;
import com.flightservices.entities.Flight;
import com.flightservices.entities.Reservation;
import com.flightservices.repositories.FlightRepository;

@RestController
public class ReservationRestController {
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping(value="/flights",method=RequestMethod.GET)
	public List<Flight> findFlights() {
		return flightRepository.findAll();
		
	}
	@RequestMapping(value="/reservations",method=RequestMethod.POST)
	public Reservation saveReservation(CreateReservationRequest request) {
		return null;
		
	}
}
