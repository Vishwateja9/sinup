package com.fullstackproject.Flight.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fullstackproject.Flight.Exception.RecordNotFoundException;
import com.fullstackproject.Flight.Model.Flight;
import com.fullstackproject.Flight.Repository.FightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FightRepository flightrepo;
	
	@Autowired
	FlightService flightservice;

	
	public List<Flight> getAllFlights() {
		return flightrepo.findAll();
	}


	public Flight createFlight(Flight flight) {
		return flightrepo.save(flight);
	}


	public ResponseEntity<Flight> getFlightById(String flightId) {
		Flight flight= flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		return ResponseEntity.ok(flight);
	}

	
	public List<Flight> findBySourceairport(String sourceairport) {
		return flightrepo.findBySourceairport(sourceairport);
	}
	
	
	
	public List<Flight> findByDstnairport(String dstnairport) {
		
		return flightrepo.findByDstnairport(dstnairport);
	}

	
	public List<Flight> findBySourceAndDstn(String sourceairport, String dstnairport) {
		
		return flightrepo.findBySourceAndDstn(sourceairport,dstnairport);
	}

	
	public List<Flight> findBydate(String date) {
		return flightrepo.findBydate(date);
	}

	
	public List<Flight> findBySourceDstnDate(String sourceairport, String dstnairport, String date) {
		return flightrepo.findBySourceDstnDate(sourceairport,dstnairport,date);
	}

	

	public ResponseEntity<Map<String, Boolean>> deleteFlight(String flightId) {
		Flight flight =flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		
		flightrepo.delete(flight);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
	public ResponseEntity<Flight> updateFlight(String flightId, Flight flightDetails) {
	
		Flight flight = flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		
		flight.setFlightName(flightDetails.getFlightName());
		flight.setSourceairport(flightDetails.getSourceairport());
		flight.setDstnairport(flightDetails.getDstnairport());
		flight.setSourcetime(flightDetails.getSourcetime());
		flight.setDstntime(flightDetails.getDstntime());
		flight.setPrice(flightDetails.getPrice());
		
		Flight updatedFlight = flightrepo.save(flight);
		return ResponseEntity.ok(updatedFlight);
	}

	
	
	
}
