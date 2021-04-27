package com.fullstackproject.Flight.Controller;

import java.util.HashMap;
import java.util.List;
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

import com.fullstackproject.Flight.Exception.RecordNotFoundException;
import com.fullstackproject.Flight.Model.Flight;
import com.fullstackproject.Flight.Repository.FightRepository;
import com.fullstackproject.Flight.Service.FlightService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class FlightController {

	@Autowired
	private FightRepository flightrepo;
	
	@Autowired
	FlightService flightservice;
	
	// get all employees
	@GetMapping("/readAllflights")
	public List<Flight> getAllFlights(){
		return flightrepo.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/createFlight")
	public Flight createFlight(@RequestBody Flight flight) {
		return flightrepo.save(flight);
	}
	
	// get employee by id rest api
	@GetMapping("/flight/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable String flightId) {
		Flight flight= flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		return ResponseEntity.ok(flight);
	}
	
	@GetMapping("/sourceflight/{sourceairport}")
	public List<Flight> findBySourceairport(@PathVariable String sourceairport) {
		
		return flightservice.findBySourceairport(sourceairport);
	}
	
	@GetMapping("/dstnflight/{dstnairport}")
	public List<Flight> findByDstnairport(@PathVariable String dstnairport) {
		
		return flightservice.findBySourceairport(dstnairport);
	}
	
	@GetMapping("/sourcedstnflights/{sourceairport}/{dstnairport}")
	public List<Flight> findBySourceAndDstn(@PathVariable String sourceairport,String dstnairport) {
		
		return flightservice.findBySourceAndDstn(sourceairport,dstnairport);
	}
	
	@GetMapping("sourcedstndate/flights/{sourceairport}/{dstnairport}/{date}")
	public List<Flight> findBySourceDstnDate(@PathVariable String sourceairport,String dstnairport,String date) {
		
		return flightservice.findBySourceDstnDate(sourceairport,dstnairport,date);
	}
	// update employee rest api
	
	@PutMapping("/flights/{flightId}")
	public ResponseEntity<Flight> updateFlight(@PathVariable String flightId, @RequestBody Flight flightDetails){
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
	
	// delete employee rest api
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String flightId){
		Flight flight =flightrepo.findById(flightId)
				.orElseThrow(() -> new RecordNotFoundException("Flight not exist with id :" + flightId));
		
		flightrepo.delete(flight);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}
