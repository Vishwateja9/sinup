package com.fullstackproject.Booking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fullstackproject.Booking.Exception.RecordNotFoundException;
import com.fullstackproject.Booking.Model.Booking;
import com.fullstackproject.Booking.Repository.BookingRepository;


@Service
public class BookingServieImpl implements BookingService {
	
	@Autowired
	BookingRepository Bookingrepo;
	
	@Autowired
	BookingService flightservice;


	@Override
	public ResponseEntity<Booking> getFlightById(String flightId) {
		Booking flight= Bookingrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		return ResponseEntity.ok(flight);
	}

}
