package com.fullstackproject.Booking.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Bookings")
public class Booking {
	
	@Id
	private String BookingId;
	
	private String noofpassengers;
	
	private String passengerName;
	
	private String passengerMail;
	
	private Flight flight;
	
	public Booking() {
		
	}



	public Booking(String noofpassengers, String passengerName, String passengerMail, Flight flight) {
		super();
		this.noofpassengers = noofpassengers;
		this.passengerName = passengerName;
		this.passengerMail = passengerMail;
		this.flight = flight;
	}



	public String getBookingId() {
		return BookingId;
	}

	public void setBookingId(String bookingId) {
		BookingId = bookingId;
	}

	public String getNoofpassengers() {
		return noofpassengers;
	}

	public void setNoofpassengers(String noofpassengers) {
		this.noofpassengers = noofpassengers;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerMail() {
		return passengerMail;
	}

	public void setPassengerMail(String passengerMail) {
		this.passengerMail = passengerMail;
	}



	public Flight getFlight() {
		return flight;
	}



	public void setFlight(Flight flight) {
		this.flight = flight;
	}



	@Override
	public String toString() {
		return "Booking [BookingId=" + BookingId + ", noofpassengers=" + noofpassengers + ", passengerName="
				+ passengerName + ", passengerMail=" + passengerMail + ", flight=" + flight + "]";
	}

	
	
	
}
