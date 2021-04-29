package com.fullstackproject.Flight.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fullstackproject.Flight.Model.Flight;
 
public interface FightRepository extends MongoRepository<Flight,String>{

public List<Flight> getAllFlights();
	
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

