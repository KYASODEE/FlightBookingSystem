package com.cg.search.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.search.exception.NotFoundException;
import com.cg.search.model.Flight;
import com.cg.search.repository.FlightRepository;

@Service
public class FlightServiceImplementation implements FlightService {
	@Autowired
	FlightRepository flightRepository;

	public List<Flight> getFlightsList() {
		List<Flight> list = flightRepository.findAll();
		if (list.isEmpty())
			throw new NotFoundException("No Flights Available");
		return list;
	}

	public Flight getFlightByNumber(@PathVariable String flightNumber) {
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		return list.get();
	}

	public Flight saveFlight(Flight flight) {
		return flightRepository.insert(flight);
	}

	public void delete(@PathVariable String flightNumber) {
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		flightRepository.deleteById(flightNumber);
	}

	public Object update(Flight flight, String flightNumber) {
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		flightRepository.deleteById(flightNumber);
		flightRepository.save(flight);
		return "Flight updated successfully";

	}

	public List<Flight> getFlightBySourceAndDestination(@PathVariable String takeoff, @PathVariable String landing) {
		List<Flight> list = flightRepository.findByTakeoffAndLanding(takeoff, landing);
		if (list.isEmpty())
			throw new NotFoundException(
					"Flight with takeoff " + takeoff + "and landing " + landing + " doesnot exist.");
		return list;

	}

	public List<Flight> getFlightBySourceAndDestinationAndDepartureDate(@PathVariable String takeoff,
			@PathVariable String landing, @PathVariable String departureDate) {
		List<Flight> list = flightRepository.findByTakeoffAndLandingAndDepartureDate(takeoff, landing, departureDate);
		if (list.isEmpty())
			throw new NotFoundException(
					"Flight with takeoff " + takeoff + "and landing " + landing + " doesnot exist.");
		return list;

	}

	public List<Flight> getFlightBySource(@PathVariable String takeoff) {
		List<Flight> list = flightRepository.findByTakeoff(takeoff);
		if (list.isEmpty())
			throw new NotFoundException("Flight with takeoff" + takeoff + " doesnot exist.");
		return list;
	}

	public List<Flight> getFlightByDestination(@PathVariable String landing) {
		List<Flight> list = flightRepository.findByLanding(landing);
		if (list.isEmpty())
			throw new NotFoundException("Flight with landing" + landing + " doesnot exist.");
		return list;
	}

}
