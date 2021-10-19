package com.system.barber.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.barber.entities.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
   List<Booking> findByBarberId(long barberId);
}