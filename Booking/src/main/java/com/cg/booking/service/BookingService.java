package com.cg.booking.service;

import static com.cg.booking.model.Booking.REFERENCE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.booking.exceptions.NotFoundException;
import com.cg.booking.model.Booking;
import com.cg.booking.model.Flight;
import com.cg.booking.repository.BookingRepository;

@Service
public class BookingService implements BookingInterface {
	
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	private RestTemplate template;

	@Autowired
	private ReferenceNumberGenerator referenceNumberGenerator;

	public Booking addBooking(Booking booking) {
		String fn=booking.getFlightNumber();
		System.out.println(fn);
		Flight flight= template.getForObject("http://search-service/search/flights/"+fn, Flight.class);
		booking.setBookingAmount(flight.getFlightFare());
		booking.setBookingid(referenceNumberGenerator.getReferenceNumber(REFERENCE));
		return bookingRepository.save(booking);
	}

	public String updateBooking(Booking booking, int bookingid) {

		Optional<Booking> list=bookingRepository.findById(bookingid);
		System.out.println(list); if(!list.isPresent()) throw new
		NotFoundException("Booking with the id "+ bookingid + "not exist");
		bookingRepository.deleteById(bookingid);
		bookingRepository.save(booking);
		return "Booking Updated with: " + booking.getBookingid();

	}

	public String deleteBooking(int bookingid) {

		if (bookingRepository.existsById(bookingid)) {
			bookingRepository.deleteById(bookingid); return
					"Booking Deleted with booking Id : "+ bookingid; } else { throw new
						NotFoundException("Booking with Id "+bookingid+" not exist"); }


	}

	public Optional<Booking> getBooking(int bookingId) {

		Optional<Booking> booking = bookingRepository.findById(bookingId); if
		(!booking.isPresent()) { throw new
			NotFoundException("No Booking available with bookingId : " + bookingId); }
		return booking;


	}

	public List<Booking> getAllBookings() {

		List<Booking> allBookingList = bookingRepository.findAll(); if
		(allBookingList.isEmpty()) { throw new
			NotFoundException("No Booking available"); } return allBookingList;


	}

	public List<Booking> getBookingsByUserId(String userid) {

		List<Booking> bookingList = bookingRepository.findByUserid(userid); if
		(bookingList == null || bookingList.isEmpty()) { throw new
			NotFoundException("No Booking available with userId : " + userid); } return
					bookingList;

	}

}
