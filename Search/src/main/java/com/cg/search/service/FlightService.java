package com.cg.search.service;

import java.util.List;

import com.cg.search.model.Flight;

public interface FlightService   {

	Flight saveFlight(Flight flight);

	List<Flight> getFlightsList();

	Object getFlightByNumber(String flightNumber);

	Object getFlightBySourceAndDestination(String takeoff, String landing);

	Object getFlightBySourceAndDestinationAndDepartureDate(String takeoff, String landing, String departureDate);

	Object getFlightBySource(String takeoff);

	Object getFlightByDestination(String landing);

	void delete(String flightNumber);

	Object update(Flight flight, String flightNumber);

	



}