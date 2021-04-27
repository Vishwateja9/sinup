package com.fullstackproject.Flight.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;


import com.fullstackproject.Flight.Model.Flight;
import com.sun.tools.javac.util.List;

public interface FlightService {
	
	public java.util.List<Flight> getAllFlights();
	
	public Flight createFlight(Flight flight);
	
	public ResponseEntity<Flight> getFlightById( String flightId);
	
   public List<Flight> findBySourceairport(String sourceairport);
    
    public List<Flight> findByDstnairport(String dstnairport);
    
    public List<Flight> findBySourceAndDstn(String sourceairport ,String dstnairport);
    
    public List<Flight> findBydate(String date);
    
    public List<Flight> findBySourceDstnDate(String sourceairport ,String dstnairport,String date);
    
    
    public ResponseEntity<Flight> updateFlight( String flightId, Flight flightDetails);
    
    public ResponseEntity<Map<String, Boolean>> deleteFlight(String flightId);
}
