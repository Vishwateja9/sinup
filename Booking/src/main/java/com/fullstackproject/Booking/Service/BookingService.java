package com.fullstackproject.Booking.Service;

import org.springframework.http.ResponseEntity;

import com.fullstackproject.Booking.Model.Booking;



public interface BookingService {

	public ResponseEntity<Booking> getFlightById( String flightId);
}
