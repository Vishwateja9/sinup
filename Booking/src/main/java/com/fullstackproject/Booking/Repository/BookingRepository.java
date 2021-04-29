package com.fullstackproject.Booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstackproject.Booking.Model.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

}
