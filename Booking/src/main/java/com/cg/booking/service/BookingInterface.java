package com.cg.booking.service;

import java.util.List;
import java.util.Optional;

import com.cg.booking.model.Booking;

public interface BookingInterface {
	
	public Booking addBooking(Booking booking);
	
	public String updateBooking(Booking booking, int bookingid);
	
	public String deleteBooking(int bookingid);
	
	public Optional<Booking> getBooking(int bookingId);
	
	public List<Booking> getAllBookings();
	
	public List<Booking> getBookingsByUserId(String userid);

}
