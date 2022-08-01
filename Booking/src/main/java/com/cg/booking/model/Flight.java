package com.cg.booking.model;

import org.springframework.data.annotation.Id;

public class Flight {
	@Id
	private String flightNumber;
	private String flightName;
	private String takeoff;
	private String landing;
	private boolean layover;
	private String duration;
	private String departureDate;
	private String arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private double flightFare;
	private int totalSeats;

	public Flight() {
		super();
	}

	public Flight(String flightNumber, String flightName, String takeoff, String landing, boolean layover,
			String duration, String departureDate, String arrivalDate, String departureTime, String arrivalTime,
			double flightFare, int totalSeats) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.takeoff = takeoff;
		this.landing = landing;
		this.layover = layover;
		this.duration = duration;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightFare = flightFare;
		this.totalSeats = totalSeats;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getTakeoff() {
		return takeoff;
	}

	public void setTakeoff(String takeoff) {
		this.takeoff = takeoff;
	}

	public String getLanding() {
		return landing;
	}

	public void setLanding(String landing) {
		this.landing = landing;
	}

	public boolean isLayover() {
		return layover;
	}

	public void setLayover(boolean layover) {
		this.layover = layover;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(double flightFare) {
		this.flightFare = flightFare;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightName=" + flightName + ", takeoff=" + takeoff
				+ ", landing=" + landing + ", layover=" + layover + ", duration=" + duration + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", flightFare=" + flightFare + ", totalSeats=" + totalSeats + "]";
	}
}
