package com.fullstackproject.Flight.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.fullstackproject.Flight.Model.Flight;


public interface FightRepository extends MongoRepository<Flight,String>{

    
}

