package com.cg.booking;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.booking.controller.BookingController;
import com.cg.booking.model.Booking;
import com.cg.booking.service.BookingService;

//@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

	private MockMvc mvc;	
	
	@InjectMocks
	BookingController bookingController;
	
	@Mock
	BookingService bookingService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(bookingController).build();
		
	}
	
	public List<Booking> getBookingDetails(){

		List<Booking> list = new ArrayList<>();
		list.add(new Booking(123, new ArrayList<>(), "1234", "Test1234", 2000.00));
		list.add(new Booking(124, new ArrayList<>(), "1235", "Test1235", 4000.00));

		return list;
	}

	public Optional<Booking> getBookingOptional(){

		Booking booking = new Booking(123, new ArrayList<>(), "1234", "Test1234",
				2000.00); 
		Optional<Booking> optional = Optional.of(booking);
		return optional;

	}

	public Booking getBooking(){

		return new Booking(123, new ArrayList<>(), "1234", "Test1234",
				2000.00); 
	}
	
	@Test
	public void testGetBookingsByUserId() throws Exception {
		
		when(bookingService.getBookingsByUserId("1")).thenReturn(getBookingDetails());
		mvc.perform(get("/fbs/booking/getBookingsByUserId/1")).andExpect(status().isOk()).
		andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
	
	@Test
	public void testGetAllBookings() throws Exception {
		
		when(bookingService.getAllBookings()).thenReturn(getBookingDetails());
		mvc.perform(get("/fbs/booking/allBookings")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
	
	@Test
	public void testGetBooking() throws Exception {
		
		when(bookingService.getBooking(1)).thenReturn(getBookingOptional());
		mvc.perform(get("/fbs/booking/getBooking/1")).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteBooking() throws Exception {
		
		when(bookingService.deleteBooking(2)).thenReturn("Booking Deleted with booking Id : 2");
		mvc.perform(delete("/fbs/booking/deleteBooking/2")).andExpect(status().isOk());

	}
	
}
