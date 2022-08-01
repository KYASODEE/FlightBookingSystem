package com.cg.booking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Booking {
	@Transient
	public static final String REFERENCE = "booking_reference";
	@Id
	private int bookingid;
	private List<Passenger> passengerList;
	private String userid;
	private String flightNumber;
	private double bookingAmount = 0;

	public Booking() {
		super();
	}

	public Booking(int bookingid, List<Passenger> passengerList, String userid, String flightNumber,
			double bookingAmount) {
		super();
		this.bookingid = bookingid;
		this.passengerList = passengerList;
		this.userid = userid;
		this.flightNumber = flightNumber;
		this.bookingAmount = bookingAmount;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public static String getReference() {
		return REFERENCE;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", passengerList=" + passengerList + ", userid=" + userid
				+ ", flightNumber=" + flightNumber + ", bookingAmount=" + bookingAmount + "]";
	}

}
