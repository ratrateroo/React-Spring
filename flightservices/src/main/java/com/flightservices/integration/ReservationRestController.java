package com.flightservices.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightservices.dto.CreateReservationRequest;
import com.flightservices.entities.Flight;
import com.flightservices.entities.Passenger;
import com.flightservices.entities.Reservation;
import com.flightservices.repositories.FlightRepository;
import com.flightservices.repositories.PassengerRepository;
import com.flightservices.repositories.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public List<Flight> findFlights() {
		return flightRepository.findAll();

	}

	@RequestMapping(value = "/reservations", method = RequestMethod.POST)
	@Transactional
	public Reservation saveReservation(CreateReservationRequest request) {
		Flight flight = flightRepository.findById(request.getFlightId()).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		return reservationRepository.save(reservation);

	}
	
	@RequestMapping(value="/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		return reservationRepository.findById(id).get();
	}
	}
}
