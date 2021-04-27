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

	@Override
	public List<Flight> getAllFlights() {
		return flightrepo.findAll();
	}

	@Override
	public Flight createFlight(Flight flight) {
		return flightrepo.save(flight);
	}

	@Override
	public ResponseEntity<Flight> getFlightById(String flightId) {
		Flight flight= flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		return ResponseEntity.ok(flight);
	}

	@Override
	public com.sun.tools.javac.util.List<Flight> findBySourceairport(String sourceairport) {
		return flightservice.findBySourceairport(sourceairport);
	}

	@Override
	public com.sun.tools.javac.util.List<Flight> findByDstnairport(String dstnairport) {
		return flightservice.findBySourceairport(dstnairport);
	}

	@Override
	public com.sun.tools.javac.util.List<Flight> findBySourceAndDstn(String sourceairport, String dstnairport) {
		return flightservice.findBySourceAndDstn(sourceairport,dstnairport);
	}

	@Override
	public com.sun.tools.javac.util.List<Flight> findBydate(String date) {
		return flightservice.findBydate(date);
	}

	@Override
	public com.sun.tools.javac.util.List<Flight> findBySourceDstnDate(String sourceairport, String dstnairport,
			String date) {
		return flightservice.findBySourceDstnDate(sourceairport,dstnairport,date);
	}




	@Override
	public ResponseEntity<Map<String, Boolean>> deleteFlight(String flightId) {
		Flight flight =flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		
		flightrepo.delete(flight);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
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
