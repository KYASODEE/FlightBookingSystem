package com.cg.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.booking.model.Booking;
import com.cg.booking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Flight Booking Controller", tags = "Flight Booking Controller")
@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @ApiOperation(value = "Get Booking details based on user ID", response = List.class, tags = "Flight Booking Controller",httpMethod = "GET")
    @GetMapping("/getBookingsByUserId/{userid}")
	public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable String userid) {
		return ResponseEntity.ok(bookingService.getBookingsByUserId(userid));		
	}

    @ApiOperation(value = "Get all booking details", response = List.class, tags = "Flight Booking Controller",httpMethod = "GET")
	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
		return ResponseEntity.ok(bookingService.getAllBookings());		
	}

    @ApiOperation(value = "Get booking details by booking id", response = Booking.class, tags = "Flight Booking Controller",httpMethod = "GET")
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Optional<Booking>> getBooking(@PathVariable int bookingId) {
		return ResponseEntity.ok(bookingService.getBooking(bookingId));
	}

    @ApiOperation(value = "creates a new booking", response = Booking.class, tags = "Flight Booking Controller",httpMethod = "POST")
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		return ResponseEntity.ok(bookingService.addBooking(booking));
	}
    
    @ApiOperation(value = "updates existing booking details based on booking ID", response = Booking.class, tags = "Flight Booking Controller",httpMethod = "POST")
	@PutMapping("/updateBooking/{bookingid}")
	public ResponseEntity<String> updateBooking(@RequestBody Booking booking, @PathVariable int bookingid) {
		return ResponseEntity.ok(bookingService.updateBooking(booking, bookingid));
	}
	
    @ApiOperation(value = "deletes booking details based on booking ID", response = Booking.class, tags = "Flight Booking Controller",httpMethod = "DELETE")
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) {
		return ResponseEntity.ok(bookingService.deleteBooking(bookingId));
	}
	
}

