package com.cg.booking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.booking.model.Booking;

public interface BookingRepository  extends MongoRepository<Booking, Integer>  {

	List<Booking> findByUserid(String userid);
	
	Booking findByBookingid(int bookingid);
	
}
