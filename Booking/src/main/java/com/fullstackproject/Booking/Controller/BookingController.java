package com.fullstackproject.Booking.Controller;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackproject.Booking.Exception.RecordNotFoundException;
import com.fullstackproject.Booking.Model.Booking;
import com.fullstackproject.Booking.Repository.BookingRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BookingController {

	@Autowired
	private BookingRepository Bookingrepo;
	
	@GetMapping("/readAllBookings")
	public Iterable<Booking> getAllBookings(){
		return Bookingrepo.findAll();
	}	
	
	// create employee rest api
	@PostMapping("/createbooking")
	public Booking createBooking(@RequestBody Booking booking) {
		return Bookingrepo.save(booking);
	}
	
	// get employee by id rest api
	@GetMapping("/Bookings/{BookingId}")
	public ResponseEntity<Booking> getEmployeeById(@PathVariable String BookingId) {
		Booking booking= Bookingrepo.findById(BookingId)
				.orElseThrow(() -> new RecordNotFoundException("Booking not exist with id :" + BookingId));
		return ResponseEntity.ok(booking);
	}
	
	// update employee rest api
	
	@PutMapping("/Bookings/{BookingId}")
	public ResponseEntity<Booking> updateEmployee(@PathVariable String BookingId, @RequestBody Booking bookingDetails){
		Booking booking = Bookingrepo.findById(BookingId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + BookingId));
		
		booking.setNoofpassengers(bookingDetails.getNoofpassengers());
		booking.setPassengerName(bookingDetails.getPassengerName());
		booking.setPassengerMail(bookingDetails.getPassengerMail());
	
		
		Booking updatedFlight = Bookingrepo.save(booking);
		return ResponseEntity.ok(updatedFlight);
	}
	
	// delete employee rest api
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String BookingId){
		Booking booking =Bookingrepo.findById(BookingId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + BookingId));
		
		Bookingrepo.delete(booking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/Booking/{flightId}")
	public ResponseEntity<Booking> getFlightById(@PathVariable String flightId) {
		Booking flight= Bookingrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		return ResponseEntity.ok(flight);
	}
	
}
